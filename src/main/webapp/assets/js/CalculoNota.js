const PERCENT = 0.30;

export function calculateGrade(score, totalMeasurements) {
    const MAX_SCORE = totalMeasurements * PERCENT;

    let percentTotal = score * 100 / MAX_SCORE;
    return Math.min(percentTotal / 10, 10);
}