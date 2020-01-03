
const recognizeFigure = (sideA, sideB, sideC, sideD) => {
    if (typeof sideA !== 'number' || typeof sideB !== 'number' || typeof sideC != 'number' || (sideD && typeof sideD !== 'number')) {
        return 'Za mało danych lub dane nie są liczbami.';
    }

    if (sideA <= 0 || sideB <= 0 || sideC <= 0 || (sideD && sideD <= 0)) {
        return 'Bok nie może wynosić 0 lub mniej.'
    }

    const maxOfSides = Math.max(sideA, sideB, sideC, sideD);
    const sumOfSides = sideA + sideB + sideC + sideD;

    // Czworobok
    if (sideD) {
        if (sideA === sideB && sideB === sideC && sideC === sideD) {
            return 'Kwadrat';
        }

        if (sideA === sideC && sideB === sideD) {
            return 'Prostokąt';
        }

        if (maxOfSides < (sumOfSides - maxOfSides)) {
            return 'Czworobok';
        }

        return 'Nierozpoznano';
    }

    // Trójkąt
    if (sideA === sideB === sideC) {
        return 'Trójkąt równoboczny'
    }

    if (sideA === sideB) {
        return 'Trójkąt równoramienny'
    }

    if (sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
        return 'Trójkąt różnoramienny'
    }

    return 'Nierozpoznano';
}

console.log(recognizeFigure(1, 2, 3, 4))