import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.scss']
})
export class ViewProductComponent implements OnInit {

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) { }
  product: any;
  productId!: string;
  ngOnInit(): void {
    this.activatedRoute.params
    .subscribe(params=>{
      this.productId = params['id'];
    })

    this.productService.viewProduct(this.productId)
    .subscribe(data=>{
      this.product = data;
    })
  }

}
