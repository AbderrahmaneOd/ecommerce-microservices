import { Component } from '@angular/core';
import { CoreService } from 'src/app/services/core.service';

@Component({
  selector: 'app-branding',
  imports: [],
  template: `
    <!-- <a href="/" class="logodark">
      <img
        src="./assets/images/logos/dark-logo.svg"
        class="align-middle m-2"
        alt="logo"
      />
      <h1 class="logo-title align-middle">Vuexy</h1>
    </a> -->
    <a href="/" class="logodark text-decoration-none">
      <h1 class="logo-title fw-normal text-primary text-center m-2" style="letter-spacing: 2px; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);">
        Admin Panel
      </h1>
    </a>
  `,
})
export class BrandingComponent {
  options = this.settings.getOptions();
  constructor(private settings: CoreService) { }
}
