import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductService } from 'src/app/services/product.service';

export interface Order{
  orderId: number;
  product: Product;
  price: number; 
  quantity: number; 
  numberOfCarton: number;
}
export interface Product{ 
  productId: number;
  name: string; 
  cartonPrice: number; 
  unitsPerCarton: number;
}
export interface BillOrder{ 
  productId: number;
  quantity: number; 
}
export interface Bill{ 
  totalAmount: number;
  eligibleDiscount: boolean; 
  discount: number;
}
@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {
  displayedColumns: string[] = ['name', 'cartonPrice', 'quantity', 'numberOfCarton', 'price'];
  displaybill: boolean = false;
  addProductForm: FormGroup = new FormGroup({});
  bill: Bill = {totalAmount: 0, eligibleDiscount: false, discount: 0};
  products: Product[] = [];
  orders: Order[] = [];
  billorders: BillOrder[] = [];
  billorder: BillOrder ={productId: 0, quantity:0};
  constructor(private formBuilder: FormBuilder, private productService: ProductService) { }
  
  createOrder(){
    console.log(this.addProductForm.value.data);
    this.productService.createOrder(this.addProductForm.value)
    .subscribe(data=>{
      this.billorder.productId = data?.product.productId;
      this.billorder.quantity = data?.quantity;
      this.billorders.push(this.billorder);
      this.orders.push(data);
    })
    this.addProductForm.reset( );
  }

  ngOnInit(): void {
    this.productService.listProducts()
    .subscribe(data => {
      this.products = data;
    });
    this.addProductForm = this.formBuilder.group({
      'productId': new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(/^-?(0|[1-9]\d*)?$/)
      ])),
      'quantity': new FormControl('', Validators.required)
    });
  }

  cratebill(){
    this.displaybill = true;
    this.productService.createBill(this.billorders)
    .subscribe(data=>{
      this.bill.discount = data.discount;
      this.bill.eligibleDiscount = data.eligibleDiscount;
      this.bill.totalAmount = data.totalAmount;
    })
  }
}
