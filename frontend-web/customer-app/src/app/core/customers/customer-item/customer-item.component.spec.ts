import { ComponentFixture, TestBed } from "@angular/core/testing";
import { CustomerItemComponent } from "./customer-item.component";
import { Customer } from "../../../shared/models/customer.model";
import { provideRouter } from "@angular/router";

describe('CustomerItemComponent', () => {
  let component: CustomerItemComponent;
  let fixture: ComponentFixture<CustomerItemComponent>;
  const mockCustomer: Customer = new Customer('Alice Johnson', 'alice.johnson@example.com', 'Brussels', 'anotherstreet', 'Belgium', 35);

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [CustomerItemComponent],
      providers: [
        provideRouter([])
      ],
      schemas: [NO_ERRORS_SCHEMA]
    });
  
    fixture = TestBed.createComponent(CustomerItemComponent);
    component = fixture.componentInstance;
  });
  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  
  it('should log the customer details to the console', () => {
    component.customer = mockCustomer;
    spyOn(console, 'log');
  
    component.getDetails();
  
    expect(console.log).toHaveBeenCalledWith(mockCustomer);
  });
  it('should render customer name in the template', () => {
    component.customer = mockCustomer;
    fixture.detectChanges();
    
    const debugElement = fixture.debugElement.query(By.css('h2'));
    expect(debugElement.nativeElement.textContent).toContain('Alice Johnson');
  });

});
