import { Component } from '@angular/core';
import { ScoreService } from './score.service'; 
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http: HttpClient, public scoreService: ScoreService) {}

  data: any;
  selectedChoice: string = '';
  error: string = '';

  getData(choice: string) {
    let url = `http://localhost:8080/api/v1/play/game/${choice}`;
    this.selectedChoice = choice;
    
    this.http.get(url).subscribe((response) => {
      this.data = response
      this.handleGameResult();
    },
    (error) => {
      this.error = 'An error occurred while making the request.';
    });
  }


  private handleGameResult() {
    if (this.data.result === 'CLIENT') {
      this.scoreService.increasePersonScore();
      this.data.result = 'You Win!';
    } else if (this.data.result === 'COMPUTER') {
      this.scoreService.increaseComputerScore();
      this.data.result = 'Computer Wins!';
    } else {
      this.data.result = 'It is a tie, try again!';
    }
  }
}