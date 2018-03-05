import { Component, OnInit } from '@angular/core';
import { book } from "../share/entity/book";
import {HttpClient, HttpHeaders} from "@angular/common/http";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  books: book[] =  [];
  headers = new HttpHeaders(
    {'Content-Type':'application/json; charset=utf-8'});

  constructor(private http: HttpClient) {

    this.http.get<any>('api/home',{headers: this.headers })
      .subscribe(
        data=> {
          this.books = data;
        }
      )
  }

  ngOnInit() {

  }

}
