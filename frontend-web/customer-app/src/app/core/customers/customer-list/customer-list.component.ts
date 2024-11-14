import { Component, inject, OnInit } from '@angular/core';
import { CustomerItemComponent } from '../customer-item/customer-item.component';
import { FilterComponent } from '../filter/filter.component';
import { Customer } from '../../../shared/models/customer.model';
import { Filter } from '../../../shared/models/filter.model';
import { CustomerService } from '../../../shared/services/customer.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CustomerItemComponent, FilterComponent],
  templateUrl: './customer-list.component.html',
  styleUrl: './customer-list.component.css'
})
export class CustomerListComponent implements OnInit {
  private filteredDataSubject = new BehaviorSubject<Customer[]>([]);
  filteredData$: Observable<Customer[]> = this.filteredDataSubject.asObservable();
  
  customerService: CustomerService = inject(CustomerService);

  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(): void {
    this.customerService.getCustomers().subscribe({
      next: (customers: Customer[]) => {
        this.filteredDataSubject.next(customers);
      }
    });
  }

  handleFilter(filter: Filter): void {
    this.customerService.filterCustomers(filter).subscribe({
      next: (customers: Customer[]) => {
        this.filteredDataSubject.next(customers);
      }
    });
  }
}