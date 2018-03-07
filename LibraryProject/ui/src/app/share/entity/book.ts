export class book{

  private _id: any;
  private _name: string;
  private _author: string;
  private _year: string;
  private _isbn: string;


  constructor(bookID: any, author: string,name: string, year: string, isbn: string) {
    this._id = bookID;
    this._author = author;
    this._name = name;
    this._year = year;
    this._isbn = isbn;
  }


  set bookID(value: any) {
    this._id = value;
  }

  set name(value: string) {
    this._name = value;
  }

  set author(value: string) {
    this._author = value;
  }

  set year(value: string) {
    this._year = value;
  }

  set isbn(value: string) {
    this._isbn = value;
  }

  get bookID(): any {
    return this._id;
  }

  get name(): string {
    return this._name;
  }

  get author(): string {
    return this._author;
  }

  get year(): string {
    return this._year;
  }

  get isbn(): string {
    return this._isbn;
  }
}
