import { Component } from '@angular/core';
import { CustomerItemComponent } from '../customer-item/customer-item.component';
import { FilterComponent } from '../filter/filter.component';
import { Customer } from '../../../shared/models/customer.model';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CustomerItemComponent, FilterComponent],
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})
export class CustomerListComponent {
  customers!: Customer[];

  ngOnInit(): void {
    this.customers = [
      new Customer('Ichigo Kurosaki', 'ichigo@pxl.be', 'Pelt', 'mystreet', 'Belgium', 21),
      new Customer('Fat Dog', 'fatDog@pxl.be', 'New York', '5th Avenue', 'USA', 6, "dogo.png"),
      new Customer('Killer Bean', 'bean@pxl.be', 'Los Angeles', 'Sunset Boulevard', 'USA', 6, "bean.png"),
    ];

    this.customers[1].isLoyal = true;
  }
}
