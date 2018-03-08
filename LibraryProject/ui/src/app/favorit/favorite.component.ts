import {Component} from "@angular/core";
import {book} from "../share/entity/book";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html'
})
export class FavoriteComponent {

  books: book[];

  headers = new HttpHeaders(
    {'Content-Type':'application/json; charset=utf-8'});

  constructor( private http: HttpClient){
    this.http.get<any>('api/getfavorite',{headers: this.headers}).subscribe(
      data=> {
        this.books = data;
        console.log(this.books);
      }
    )
  }

  delteFavoriteBook(book: book){
    this.http.post<any>('api/deletefavorite', book,{headers: this.headers}).subscribe(
      data=> {
        var index = this.books.indexOf(book, 0);
        if (index > -1) {
          this.books.splice(index, 1);
        }
      }
    )

  }

}
