import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bill, BillOrder, Order, Product } from '../products/add-product/add-product.component';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
// localhost:8080/products
  baseUrl :string = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  listProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl+ 'products/');
  }
  viewProduct(id: string): Observable<Product>{
    return this.http.get<Product>(this.baseUrl + 'products/' + id);
  }
  createOrder(order: any): Observable<Order>{
    return this.http.post<Order>(this.baseUrl+ 'order', order);
  }

  createBill(billorders: BillOrder[]): Observable<Bill>{
    return this.http.post<Bill>(this.baseUrl+ 'bill', billorders);
  }
}