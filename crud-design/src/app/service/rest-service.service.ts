import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo } from '../model/user-info/UserInfo.model';

@Injectable({
  providedIn: 'root'
})
export class RestServiceService {

  constructor(private http:HttpClient) { }

  getAll():Observable<UserInfo[]> {
      return this.http.get<UserInfo[]>("http://localhost:8000/user/getAll");
  }

  create(user:UserInfo) :Observable<UserInfo> {
    return this.http.post<UserInfo>("http://localhost:8000/user/create",user);
  }

  delete(id:string) {
    return this.http.delete(`http://localhost:8000/user/deleteById/${id}`);
  }

}
