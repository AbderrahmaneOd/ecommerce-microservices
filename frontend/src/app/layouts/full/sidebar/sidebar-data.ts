import { NavItem } from './nav-item/nav-item';

export const navItems: NavItem[] = [
  {
    navCap: 'Home',
  },
  {
    displayName: 'Dashboard',
    iconName: 'layout-grid-add',
    route: '/dashboard',
    bgcolor: 'primary',
  },
  {
    displayName: 'Users',
    iconName: 'table',
    route: '/users',
    bgcolor: 'success',
  },
  // {
  //   displayName: 'Dashboard 1',
  //   iconName: 'layout-dashboard',
  //   route: 'https://spike-angular-pro-main.netlify.app/dashboards/dashboard1',
  //   bgcolor: 'secondary',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Dashboard 2',
  //   iconName: 'chart-bar',
  //   route: 'https://spike-angular-pro-main.netlify.app/dashboards/dashboard2',
  //   bgcolor: 'warning',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },

  // {
  //   navCap: 'Apps',
  // },
  // {
  //   displayName: 'Chat',
  //   iconName: 'message-dots',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/chat',
  //   bgcolor: 'success',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Calendar',
  //   iconName: 'calendar',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/calendar',
  //   bgcolor: 'error',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Email',
  //   iconName: 'mail',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/email/inbox',
  //   bgcolor: 'primary',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Kanban',
  //   iconName: 'checklist',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/kanban',
  //   bgcolor: 'warning',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Contacts',
  //   iconName: 'phone',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/contacts',
  //   bgcolor: 'success',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Contact List',
  //   iconName: 'list-details',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/contact-list',
  //   bgcolor: 'error',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Courses',
  //   iconName: 'certificate',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/courses',
  //   bgcolor: 'primary',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Employee',
  //   iconName: 'brand-ctemplar',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/employee',
  //   bgcolor: 'secondary',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Notes',
  //   iconName: 'note',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/notes',
  //   bgcolor: 'warning',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Tickets',
  //   iconName: 'ticket',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/tickets',
  //   bgcolor: 'success',
  //   chip: true,
  //   external: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'ToDo',
  //   iconName: 'edit',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/todo',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Invoice',
  //   iconName: 'file-invoice',
  //   bgcolor: 'primary',
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  //   route: '',
  //   children: [
  //     {
  //       displayName: 'List',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/apps/invoice',
  //     },
  //     {
  //       displayName: 'Detail',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/apps/viewInvoice/101',
  //     },
  //     {
  //       displayName: 'Create',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/apps/addInvoice',
  //     },
  //     {
  //       displayName: 'Edit',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/apps/editinvoice/101',
  //     },
  //   ],
  // },
  
  // {
  //   displayName: 'Blog',
  //   iconName: 'chart-donut-3',
  //   bgcolor: 'secondary',
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  //   route: 'apps/blog',
  //   children: [
  //     {
  //       displayName: 'Post',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/apps/blog/post',
  //     },
  //     {
  //       displayName: 'Detail',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/apps/blog/detail/Early Black Friday Amazon deals: cheap TVs, headphones, laptops',
  //     },
  //   ],
  // },

  // {
  //   navCap: 'Ui Components',
  // },
  // {
  //   displayName: 'Badge',
  //   iconName: 'archive',
  //   route: '/ui-components/badge',
  //   bgcolor: 'warning',
  // },
  // {
  //   displayName: 'Chips',
  //   iconName: 'info-circle',
  //   route: '/ui-components/chips',
  //   bgcolor: 'success',
  // },
  // {
  //   displayName: 'Lists',
  //   iconName: 'list-details',
  //   route: '/ui-components/lists',
  //   bgcolor: 'error',
  // },
  // {
  //   displayName: 'Menu',
  //   iconName: 'file-text',
  //   route: '/ui-components/menu',
  //   bgcolor: 'primary',
  // },
  // {
  //   displayName: 'Tooltips',
  //   iconName: 'file-text-ai',
  //   route: '/ui-components/tooltips',
  //   bgcolor: 'secondary',
  // },
  // {
  //   displayName: 'Forms',
  //   iconName: 'clipboard-text',
  //   route: '/ui-components/forms',
  //   bgcolor: 'warning',
  // },
  // {
  //   displayName: 'Tables',
  //   iconName: 'table',
  //   route: '/ui-components/tables',
  //   bgcolor: 'success',
  // },
  // {
  //   displayName: 'Expansion Panel',
  //   iconName: 'layout-bottombar-inactive',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/expansion',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Dialog',
  //   iconName: 'diabolo',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/dialog',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Divider',
  //   iconName: 'separator',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/divider',
  //   bgcolor: 'secondary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Paginator',
  //   iconName: 'text-wrap',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/paginator',
  //   bgcolor: 'warning',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Progress Bar',
  //   iconName: 'progress',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/progress',
  //   bgcolor: 'success',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Progress Spinner',
  //   iconName: 'rotate-2',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/progress-spinner',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Ripples',
  //   iconName: 'ripple',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/ripples',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Slide Toggle',
  //   iconName: 'toggle-left',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/slide-toggle',
  //   bgcolor: 'secondary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Slider',
  //   iconName: 'adjustments-alt',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/slider',
  //   bgcolor: 'warning',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Snackbar',
  //   iconName: 'stack-backward',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/snackbar',
  //   bgcolor: 'success',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Tabs',
  //   iconName: 'border-all',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/tabs',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Toolbar',
  //   iconName: 'tools-kitchen',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/toolbar',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Tooltips',
  //   iconName: 'tooltip',
  //   route: 'https://spike-angular-pro-main.netlify.app/ui-components/tooltips',
  //   bgcolor: 'secondary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },

  // {
  //   navCap: 'Pages',
  // },
  // {
  //   displayName: 'Roll Base Access',
  //   iconName: 'lock-access',
  //   route: 'https://spike-angular-pro-main.netlify.app/apps/permission',
  //   bgcolor: 'warning',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Treeview',
  //   iconName: 'git-merge',
  //   route: 'https://spike-angular-pro-main.netlify.app/theme-pages/treeview',
  //   bgcolor: 'success',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Pricing',
  //   iconName: 'currency-dollar',
  //   route: 'https://spike-angular-pro-main.netlify.app/theme-pages/pricing',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Account Setting',
  //   iconName: 'user-circle',
  //   route: 'https://spike-angular-pro-main.netlify.app/theme-pages/account-setting',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'FAQ',
  //   iconName: 'help',
  //   route: 'https://spike-angular-pro-main.netlify.app/theme-pages/faq',
  //   bgcolor: 'secondary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Landingpage',
  //   iconName: 'app-window',
  //   route: 'https://spike-angular-pro-main.netlify.app/landingpage',
  //   bgcolor: 'warning',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Widgets',
  //   iconName: 'layout',
  //   route: 'widgets',
  //   bgcolor: 'success',
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  //   children: [
  //     {
  //       displayName: 'Cards',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/widgets/cards',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Banners',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/widgets/banners',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Charts',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/widgets/charts',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //   ],
  // },
  // {
  //   navCap: 'Extra',
  // },
  // {
  //   displayName: 'Icons',
  //   iconName: 'mood-smile',
  //   route: '/extra/icons',
  //   bgcolor: 'error',
  // },
  // {
  //   displayName: 'Sample Page',
  //   iconName: 'brand-dribbble',
  //   route: '/extra/sample-page',
  //   bgcolor: 'primary',
  // },
  // {
  //   navCap: 'Forms',
  // },
  // {
  //   displayName: 'Elements',
  //   iconName: 'apps',
  //   bgcolor: 'secondary',
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  //   route: 'forms/forms-elements',
  //   children: [
  //     {
  //       displayName: 'Autocomplete',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/forms/forms-elements/autocomplete',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Button',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/forms/forms-elements/button',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Checkbox',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/forms/forms-elements/checkbox',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Radio',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/forms/forms-elements/radio',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Datepicker',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/forms/forms-elements/datepicker',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //   ],
  // },
  // {
  //   displayName: 'Form Layouts',
  //   iconName: 'file-description',
  //   route: 'https://spike-angular-pro-main.netlify.app/forms/form-layouts',
  //   bgcolor: 'warning',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Form Horizontal',
  //   iconName: 'box-align-bottom',
  //   route: 'https://spike-angular-pro-main.netlify.app/forms/form-horizontal',
  //   bgcolor: 'success',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Form Vertical',
  //   iconName: 'box-align-left',
  //   route: 'https://spike-angular-pro-main.netlify.app/forms/form-vertical',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Form Wizard',
  //   iconName: 'files',
  //   route: 'https://spike-angular-pro-main.netlify.app/forms/form-wizard',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Toastr',
  //   iconName: 'notification',
  //   route: 'https://spike-angular-pro-main.netlify.app/forms/form-toastr',
  //   bgcolor: 'secondary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  
  // {
  //   navCap: 'Tables',
  // },
  // {
  //   displayName: 'Tables',
  //   iconName: 'layout',
  //   route: 'tables',
  //   bgcolor: 'warning',
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  //   children: [
  //     {
  //       displayName: 'Basic Table',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/tables/basic-table',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Dynamic Table',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/tables/dynamic-table',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Expand Table',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/tables/expand-table',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Filterable Table',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/filterable-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Footer Row Table',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/footer-row-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'HTTP Table',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/tables/http-table',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Mix Table',
  //       iconName: 'point',
  //       route: 'https://spike-angular-pro-main.netlify.app/tables/mix-table',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Multi Header Footer',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/multi-header-footer-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Pagination Table',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/pagination-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Row Context Table',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/row-context-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Selection Table',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/selection-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Sortable Table',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/sortable-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Sticky Column',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/sticky-column-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //     {
  //       displayName: 'Sticky Header Footer',
  //       iconName: 'point',
  //       route:
  //         'https://spike-angular-pro-main.netlify.app/tables/sticky-header-footer-table',
  //       bgcolor: 'tranparent',
  //         external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //     },
  //   ],
  // },
  // {
  //   displayName: 'Data table',
  //   iconName: 'border-outer',
  //   route: 'https://spike-angular-pro-main.netlify.app/datatable/kichen-sink',
  //   bgcolor: 'success',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   navCap: 'Chart',
  // },
  // {
  //   displayName: 'Line',
  //   iconName: 'chart-line',
  //   route: 'https://spike-angular-pro-main.netlify.app/charts/line',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Gredient',
  //   iconName: 'chart-arcs',
  //   route: 'https://spike-angular-pro-main.netlify.app/charts/gredient',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Area',
  //   iconName: 'chart-area',
  //   route: 'https://spike-angular-pro-main.netlify.app/charts/area',
  //   bgcolor: 'secondary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Candlestick',
  //   iconName: 'chart-candle',
  //   route: 'https://spike-angular-pro-main.netlify.app/charts/candlestick',
  //   bgcolor: 'warning',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Column',
  //   iconName: 'chart-dots',
  //   route: 'https://spike-angular-pro-main.netlify.app/charts/column',
  //   bgcolor: 'success',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Doughnut & Pie',
  //   iconName: 'chart-donut-3',
  //   route: 'https://spike-angular-pro-main.netlify.app/charts/doughnut-pie',
  //   bgcolor: 'error',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Radialbar & Radar',
  //   iconName: 'chart-radar',
  //   route: 'https://spike-angular-pro-main.netlify.app/charts/radial-radar',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },

  // {
  //   navCap: 'Auth',
  // },
  // {
  //   displayName: 'Login',
  //   iconName: 'login',
  //   bgcolor: 'secondary',
  //   route: '/authentication',
  //   children: [
  //     {
  //       displayName: 'Login',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       route: '/authentication/login',
  //     },
  //     {
  //       displayName: 'Side Login',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white', 
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/authentication/login',
  //     },
  //   ],
  // },
  // {
  //   displayName: 'Register',
  //   iconName: 'user-plus',
  //   bgcolor: 'warning',
  //   route: '/authentication',
  //   children: [
  //     {
  //       displayName: 'Register',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       route: '/authentication/register',
  //     },
  //     {
  //       displayName: 'Side Register',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/authentication/side-register',
  //     },
  //   ],
  // },
  // {
  //   displayName: 'Forgot Pwd',
  //   iconName: 'rotate',
  //   bgcolor: 'success',
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  //   route: '/authentication',
  //   children: [
  //     {
  //       displayName: 'Side Forgot Pwd',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/authentication/side-forgot-pwd',
  //     },
  //     {
  //       displayName: 'Boxed Forgot Pwd',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/authentication/boxed-forgot-pwd',
  //     },
  //   ],
  // },
  // {
  //   displayName: 'Two Steps',
  //   iconName: 'zoom-code',
  //   bgcolor: 'error',
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  //   route: '/authentication',
  //   children: [
  //     {
  //       displayName: 'Side Two Steps',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/authentication/side-two-steps',
  //     },
  //     {
  //       displayName: 'Boxed Two Steps',
  //       iconName: 'point',
  //       bgcolor: 'tranparent',
  //       external: true,
  //       chip: true,
  //       chipClass: 'bg-primary text-white',
  //       chipContent: 'PRO',
  //       route: 'https://spike-angular-pro-main.netlify.app/authentication/boxed-two-steps',
  //     },
  //   ],
  // },
  // {
  //   displayName: 'Error',
  //   iconName: 'alert-circle',
  //   route: 'https://spike-angular-pro-main.netlify.app/authentication/error',
  //   bgcolor: 'primary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
  // {
  //   displayName: 'Maintenance',
  //   iconName: 'settings',
  //   route: 'https://spike-angular-pro-main.netlify.app/authentication/maintenance',
  //   bgcolor: 'secondary',
  //   external: true,
  //   chip: true,
  //   chipClass: 'bg-primary text-white',
  //   chipContent: 'PRO',
  // },
];
