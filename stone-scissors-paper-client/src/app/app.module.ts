import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; // HttpClientModule'i ekleyin

import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, HttpClientModule], // HttpClientModule'i ekleyin
  bootstrap: [AppComponent]
})
export class AppModule { }