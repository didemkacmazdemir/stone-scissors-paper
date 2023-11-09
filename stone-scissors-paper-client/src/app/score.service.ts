import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ScoreService {
  computerScore = 0;
  personScore = 0;

  increaseComputerScore() {
    this.computerScore++;
  }

  increasePersonScore() {
    this.personScore++;
  }

  resetScores() {
    this.computerScore = 0;
    this.personScore = 0;
  }
}