import { startTimer, stopTimer } from "./timer.js";
import { calculateGrade } from "./CalculoNota.js";

document.addEventListener("DOMContentLoaded", () => {

    const btnPlay = document.getElementById("play");
    const btnStop = document.getElementById("stop");
    const downloadLink = document.getElementById("download");

    let audioChunks = [];
    let mediaRecorder;
    let stream;

    let audioContext = null;
    let analyser = null;
    let source = null;
    let isMeasuring = false;

    let dataArray;
    let bufferLength;

    let score = 0;
    let totalMeasurements = 0;
    let finalGrade = 0;

    const onMediaRecorderStop = () => {
        const audioBlob = new Blob(audioChunks, { type: "audio/webm" });
        downloadLink.href = URL.createObjectURL(audioBlob);
        downloadLink.download = `gravacao-${Date.now()}.webm`;
        downloadLink.style.display = "block";

        audioChunks = [];
    };

    btnPlay.addEventListener("click", async () => {

        if (!stream) {
            try {
                stream = await navigator.mediaDevices.getUserMedia({ audio: true });
            } catch (e) {
                alert("Não é possível medir seu grito sem permissão!");
                return;
            }
        }

        mediaRecorder = new MediaRecorder(stream);
        mediaRecorder.ondataavailable = event => {
            audioChunks.push(event.data);
        };
        mediaRecorder.onstop = onMediaRecorderStop;

        if (!audioContext) {
            audioContext = new AudioContext();
        }

        if (!source) {
            source = audioContext.createMediaStreamSource(stream);
            analyser = audioContext.createAnalyser();

            analyser.fftSize = 2048;
            bufferLength = analyser.frequencyBinCount;
            dataArray = new Uint8Array(bufferLength);

            source.connect(analyser);
        }

        isMeasuring = true;
        score = 0
        totalMeasurements = 0;
        measureVolume();

        mediaRecorder.start();
        startTimer();

        btnPlay.disabled = true;
        btnStop.disabled = false;
        setTimeout( () => stop(), 1000 * 10);
    });

    btnStop.addEventListener("click", () => {
        stop()
    });
    function stop(){
        if (!mediaRecorder) return;

        mediaRecorder.stop();
        stopTimer();
        stopAudioProcessing();
        stopUserMedia();

        isMeasuring = false;
        btnStop.disabled = true;
        btnPlay.disabled = false;

        finalGrade = calculateGrade(score, totalMeasurements);
        showGrade(finalGrade)

        console.log("Score", score)
        console.log("Total medidas", totalMeasurements);
        console.log("Nota final", finalGrade)
    }

    function measureVolume() {
        if (!isMeasuring || !analyser) return;

        analyser.getByteTimeDomainData(dataArray);

        let sum = 0;
        for (let i = 0; i < bufferLength; i++) {
            const value = (dataArray[i] - 128) / 128;
            sum += value * value;
        }

        const rms = Math.sqrt(sum / bufferLength);
        totalMeasurements++;
        if (rms >= 0.35) score++;

        requestAnimationFrame(measureVolume);
    }

    function stopAudioProcessing() {
        if (source) {
            source.disconnect();
            source = null;
        }

        analyser = null;

        if (audioContext) {
            audioContext.close();
            audioContext = null;
        }
    }

    function stopUserMedia() {
        if (!stream) return;

        stream.getTracks().forEach(track => track.stop());
        stream = null;
    }
    function showGrade(grade) {
        const finalGradeContainer = document.getElementById("notaFinal");
        grade = parseFloat(grade)
        finalGradeContainer.textContent = `${grade.toFixed(2)}`
    }
});
