const PERCENT = 0.10;

export function calculateGrade(score, totalMeasurements) {
    const MAX_SCORE = totalMeasurements * PERCENT;

    let percentTotal = score * 100 / MAX_SCORE;
    let nota = Math.min(percentTotal / 10, 10)
    return nota.toFixed(2);
}