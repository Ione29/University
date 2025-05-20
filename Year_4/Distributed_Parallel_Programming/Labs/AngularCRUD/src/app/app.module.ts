import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    TutorialDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    TutorialsListComponent,
    AddTutorialComponent
],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
