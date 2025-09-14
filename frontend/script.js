const cells = document.querySelectorAll(".cell");
const message = document.querySelector(".message");
const resetButton = document.getElementById("reset");

let isXTurn = true;
let gameOver = false;

const winningCombinations = [
  [0, 1, 2],
  [3, 4, 5],
  [6, 7, 8],
  [0, 3, 6],
  [1, 4, 7],
  [2, 5, 8],
  [0, 4, 8],
  [2, 4, 6],
];

// Handle cell click
cells.forEach((cell, index) => {
  cell.addEventListener("click", () => {
    if (cell.textContent !== "" || gameOver) return;

    const currentPlayer = isXTurn ? "X" : "O";
    cell.textContent = currentPlayer;

    if (checkWin(currentPlayer)) {
      message.textContent = currentPlayer + " wins!";
      gameOver = true;
      return;
    }

    if (isDraw()) {
      message.textContent = "It's a Draw!";
      gameOver = true;
      return;
    }

    isXTurn = !isXTurn;
  });
});

// Check win
function checkWin(currentPlayer) {
  for (let combination of winningCombinations) {
    if (
      combination.every((index) => cells[index].textContent === currentPlayer)
    ) {
      combination.forEach((index) => {
        cells[index].classList.add("winner");
      });
      return true;
    }
  }
  return false;
}

// Check draw
function isDraw() {
  return [...cells].every((cell) => cell.textContent !== "");
}

// Reset game
resetButton.addEventListener("click", () => {
  cells.forEach((cell) => {
    cell.textContent = "";
    cell.classList.remove("winner");
  });
  message.textContent = "";
  isXTurn = true;
  gameOver = false;
});
