import { Component, Input, OnInit, SimpleChanges } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductService } from 'src/app/services/product.service';




// const ELEMENT_DATA: Order[] = [
//   { orderId: 40, product: { productId: 253, name: 'Horseshoe', cartonPrice: 825, unitsPerCarton: 5 }, price: 12804, quantity: 77, numberOfCarton: 15 },
// ];





@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.scss']
})
export class ListProductsComponent implements OnInit {

  

  products: any;
  display: boolean = true;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.listProducts()
    .subscribe(data => {
      this.products = data;
    })
  }

  

  

}
