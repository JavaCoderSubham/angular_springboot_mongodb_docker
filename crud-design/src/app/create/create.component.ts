import { Component } from '@angular/core';
import { UserInfo } from '../model/user-info/UserInfo.model';
import { RestServiceService } from '../service/rest-service.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent {

  user:UserInfo;

  constructor(private rest:RestServiceService) {
    this.user = new UserInfo('','','','',0,false,false);
  }

  onClickCreate() {
    this.rest.create(this.user).subscribe((data) => {
      this.user.name = ''
      this.user.email = ''
      this.user.password = ''
      this.user.age = 0
    })
  }

}
