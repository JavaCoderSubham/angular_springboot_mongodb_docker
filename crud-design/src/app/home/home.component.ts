import { Component } from '@angular/core';
import { RestServiceService } from '../service/rest-service.service';
import { UserInfo } from '../model/user-info/UserInfo.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  userInfo:UserInfo[] = []

  constructor(private restService:RestServiceService) {}

  ngOnInit() {
    this.restService.getAll().subscribe((data) => {
      console.log(data)
      this.userInfo = data;
    })
  }


  onClickUpdate(id:string, user:UserInfo) {

  }

  onClickDelete(id:string) {
    this.restService.delete(id).subscribe(() => window.location.reload());
  }

  onCheckBoxClick(event:any, user:UserInfo) {
    if(event.target.checked) {
      user.checkBox = true
    }
    else {
      user.checkBox = false
    }
  }

  onCheckBoxAll(event:any) {
    if(event.target.checked) {
      this.userInfo.forEach((value) => value.checkBox = true)
    }
    else {
      this.userInfo.forEach((value) => value.checkBox = false)
    }
  }

}
