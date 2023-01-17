export class SearchParams{

  title?:string;
  runtime?:number;
  dateFrom?:Date
  dateTo?:Date;
  language:string;
  constructor(public page:number, public pageSize:number) {
  }
}
