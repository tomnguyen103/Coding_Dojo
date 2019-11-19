import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _httpClient: HttpClient) { }

  getPets(){
    return this._httpClient.get('/api/pets')
  }

  deletePet(id){
    return this._httpClient.delete('/api/pets/' + id)
  }

  createPet(pet){
    return this._httpClient.post('/api/pets', pet)
  }

  getPetById(id){
    return this._httpClient.get('/api/pets/'+id)
  }

  updatePet(id, newData){
    return this._httpClient.put('/api/pets/'+id , newData)
  }
}
