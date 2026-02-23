
const btnPlay = document.getElementById("play");
const btnStop = document.getElementById("stop");
const timer = document.getElementById("timer");
timer.style.color = "black";

let timerInterval;
let seg = 10;

export function startTimer() {
    timer.textContent = formatTimer();
    timerInterval = setInterval(() => {
        seg--;
        if (seg <= 5){
            timer.style.color = "red";
        }
        timer.textContent = formatTimer()
    }, 1000)
    btnStop.disabled = true;
    btnPlay.disabled = true;
}
function formatTimer() {
    const minutos = String(Math.floor(seg / 60)).padStart(2, "0");
    const segundosRestantes = String(seg % 60).padStart(2, "0");
    return `${minutos}:${segundosRestantes}`;
}
export function stopTimer() {
    clearInterval(timerInterval);
    seg = 10;
    btnStop.disabled = false;
    btnPlay.disabled = false;
    timer.style.color = "black";
}

