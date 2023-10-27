import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http: HttpClient) {}
  data: any

  sendDataToJava(choice: string) {
    let url = `http://localhost:8080/api/v1/play/game/${choice}`;
     
    this.http.get(url).subscribe((response) => {
      this.data = response
    });
  }
}