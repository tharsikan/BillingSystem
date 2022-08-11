import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './products/add-product/add-product.component';
import { ListProductsComponent } from './products/list-products/list-products.component';
import { ViewProductComponent } from './products/view-product/view-product.component';

const routes: Routes = [
  
  { path: 'products',
    children: [ 
      { path: '', component: ListProductsComponent},
      { path: 'list', component: ListProductsComponent},
      { path: 'add', component: AddProductComponent},
      { path: 'view/:id', component: ViewProductComponent},
      { path: 'edit/:id', component: ListProductsComponent},
      { path: 'delete/:id', component: ListProductsComponent}
    ]
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
