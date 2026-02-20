
const btnPlay = document.getElementById("play");
const btnStop = document.getElementById("stop");
const timer = document.getElementById("timer");

let timerInterval;
let seg = 0;

export function startTimer() {
    timer.textContent = formatTimer();
    timerInterval = setInterval(() => {
        seg++;
        timer.textContent = formatTimer()
    }, 1000)
    btnStop.disabled = false;
}
function formatTimer() {
    const minutos = String(Math.floor(seg / 60)).padStart(2, "0");
    const segundosRestantes = String(seg % 60).padStart(2, "0");
    return `${minutos}:${segundosRestantes}`;
}
export function stopTimer() {
    clearInterval(timerInterval);
    seg = 0;
    btnStop.disabled = true;
}

