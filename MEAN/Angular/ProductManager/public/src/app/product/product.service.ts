import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _httpClient: HttpClient) { }

  getProduct(){
    return this._httpClient.get('/api/products')
  }

  deleteProduct(id){
    return this._httpClient.delete('/api/products'+id)
  }

  createProduct(product){
    return this._httpClient.post('/api/products', product)
  }

  getProductById(id){
    return this._httpClient.get('/api/products/' + id)
  }

  updateProduct(id, newData){
    return this._httpClient.put('/api/products/'+id, newData)
  }
}
