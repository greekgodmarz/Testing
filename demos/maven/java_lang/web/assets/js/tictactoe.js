const X_CLASS = 'x';
const O_CLASS = 'o';
const WINNING_COMBINATIONS = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
];

const cellElements = document.querySelectorAll('[data-cell]');
const board = document.getElementById('tic-tac-toe-board');
const winningMessageElement = document.getElementById('winning-message');
const winnerElement = document.getElementById('winner');
const restartButton = document.getElementById('restart-button');
let oTurn;

startGame();

restartButton.addEventListener('click', startGame);

function startGame() {
    oTurn = false;
    cellElements.forEach(cell => {
        cell.classList.remove(X_CLASS);
        cell.classList.remove(O_CLASS);
        cell.removeEventListener('click', handleClick);
        cell.addEventListener('click', handleClick, { once: true });
    });
    setBoardHoverClass();
    winningMessageElement.classList.add('hide');
}

function handleClick(e) {
    const cell = e.target;
    const currentClass = X_CLASS; // Always X when player clicks
    placeMark(cell, currentClass);
    if (checkWin(currentClass)) {
        endGame(false);
    } else if (isDraw()) {
        endGame(true);
    } else {
        swapTurns();
        setBoardHoverClass();
        setTimeout(() => makeAiMove(), 1000); // AI move after 1 second
    }
}

function makeAiMove() {
    const availableCells = [...cellElements].filter(cell => {
        return !cell.classList.contains(X_CLASS) && !cell.classList.contains(O_CLASS);
    });

    if (availableCells.length === 0) return;

    const randomIndex = Math.floor(Math.random() * availableCells.length);
    const cell = availableCells[randomIndex];
    placeMark(cell, O_CLASS);

    if (checkWin(O_CLASS)) {
        endGame(false);
    } else if (isDraw()) {
        endGame(true);
    } else {
        swapTurns();
        setBoardHoverClass();
    }
}

function endGame(draw) {
    if (draw) {
        winnerElement.innerText = 'Draw!';
    } else {
        winnerElement.innerText = `${oTurn ? "O's" : "X's"}`;
    }
    winningMessageElement.classList.remove('hide');
}

function isDraw() {
    return [...cellElements].every(cell => {
        return cell.classList.contains(X_CLASS) || cell.classList.contains(O_CLASS);
    });
}

function placeMark(cell, currentClass) {
    cell.classList.add(currentClass);
}

function swapTurns() {
    oTurn = !oTurn;
}

function setBoardHoverClass() {
    board.classList.remove(X_CLASS);
    board.classList.remove(O_CLASS);
    if (oTurn) {
        board.classList.add(O_CLASS);
    } else {
        board.classList.add(X_CLASS);
    }
}

function checkWin(currentClass) {
    return WINNING_COMBINATIONS.some(combination => {
        return combination.every(index => {
            return cellElements[index].classList.contains(currentClass);
        });
    });
}
