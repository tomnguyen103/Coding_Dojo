import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  errors = []

  newProduct = {
    title: '',
    price: '',
    img_url: ''
  }

  constructor(
    private _productService: ProductService,
    private _router: Router
  ) { }

  ngOnInit() {
  }

  handleSubmit(){
    this._productService.createProduct(this.newProduct)
    .subscribe((data:any)=>{
      if(data.hasOwnProperty('errors')){
        for(let key in data.errors){
          this.errors.push(data.errors[key].message)
        }
      }else{
        this._router.navigate(['/products'])
      }
    })
  }

}
