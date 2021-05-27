# Linked List

A Linked List is a sequence of **Nodes** where each **Node** contains a value and potentially a reference
to another **Node** that is arbituarily located on the Heap. The image below represents the Node structure of two Linked Lists of integers.
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="500" height="100" viewBox="0 0 452.174 123">
  <defs>
    <filter id="Rectangle_1" x="0" y="0" width="103" height="57" filterUnits="userSpaceOnUse">
      <feOffset dx="-6" dy="6" input="SourceAlpha"/>
      <feGaussianBlur result="blur"/>
      <feFlood flood-opacity="0.161"/>
      <feComposite operator="in" in2="blur"/>
      <feComposite in="SourceGraphic"/>
    </filter>
    <filter id="Rectangle_2" x="0.326" y="66" width="103" height="57" filterUnits="userSpaceOnUse">
      <feOffset dx="-6" dy="6" input="SourceAlpha"/>
      <feGaussianBlur result="blur-2"/>
      <feFlood flood-opacity="0.161"/>
      <feComposite operator="in" in2="blur-2"/>
      <feComposite in="SourceGraphic"/>
    </filter>
    <filter id="Rectangle_3" x="136.674" y="62.25" width="103" height="57" filterUnits="userSpaceOnUse">
      <feOffset dx="-6" dy="6" input="SourceAlpha"/>
      <feGaussianBlur result="blur-3"/>
      <feFlood flood-opacity="0.161"/>
      <feComposite operator="in" in2="blur-3"/>
      <feComposite in="SourceGraphic"/>
    </filter>
    <filter id="Rectangle_4" x="273.522" y="62" width="103" height="57" filterUnits="userSpaceOnUse">
      <feOffset dx="-6" dy="6" input="SourceAlpha"/>
      <feGaussianBlur result="blur-4"/>
      <feFlood flood-opacity="0.161"/>
      <feComposite operator="in" in2="blur-4"/>
      <feComposite in="SourceGraphic"/>
    </filter>
  </defs>
  <g transform="matrix(1, 0, 0, 1, 0, 0)" filter="url(#Rectangle_1)">
    <g id="Rectangle_1-2" data-name="Rectangle 1" transform="translate(6)" fill="#fff" stroke="#707070" stroke-linejoin="round" stroke-width="2">
      <rect width="97" height="51" rx="21" stroke="none"/>
      <rect x="1" y="1" width="95" height="49" rx="20" fill="none"/>
    </g>
  </g>
  <g transform="matrix(1, 0, 0, 1, 0, 0)" filter="url(#Rectangle_2)">
    <g id="Rectangle_2-2" data-name="Rectangle 2" transform="translate(6.33 66)" fill="#fff" stroke="#707070" stroke-linejoin="round" stroke-width="2">
      <rect width="97" height="51" rx="21" stroke="none"/>
      <rect x="1" y="1" width="95" height="49" rx="20" fill="none"/>
    </g>
  </g>
  <g transform="matrix(1, 0, 0, 1, 0, 0)" filter="url(#Rectangle_3)">
    <g id="Rectangle_3-2" data-name="Rectangle 3" transform="translate(142.67 62.25)" fill="#fff" stroke="#707070" stroke-linejoin="round" stroke-width="2">
      <rect width="97" height="51" rx="21" stroke="none"/>
      <rect x="1" y="1" width="95" height="49" rx="20" fill="none"/>
    </g>
  </g>
  <g transform="matrix(1, 0, 0, 1, 0, 0)" filter="url(#Rectangle_4)">
    <g id="Rectangle_4-2" data-name="Rectangle 4" transform="translate(279.52 62)" fill="#fff" stroke="#707070" stroke-linejoin="round" stroke-width="2">
      <rect width="97" height="51" rx="21" stroke="none"/>
      <rect x="1" y="1" width="95" height="49" rx="20" fill="none"/>
    </g>
  </g>
  <line id="Line_1" data-name="Line 1" y2="50.682" transform="translate(71.221 0.818)" fill="none" stroke="#707070" stroke-width="1"/>
  <line id="Line_3" data-name="Line 3" y2="50.682" transform="translate(71.547 66.818)" fill="none" stroke="#707070" stroke-width="1"/>
  <line id="Line_5" data-name="Line 5" y2="50.682" transform="translate(207.895 63.068)" fill="none" stroke="#707070" stroke-width="1"/>
  <line id="Line_8" data-name="Line 8" y2="50.682" transform="translate(344.744 62.818)" fill="none" stroke="#707070" stroke-width="1"/>
  <text id="_10" data-name="10" transform="translate(37 34)" fill="#707070" font-size="20" font-family="SegoeUI, Segoe UI"><tspan x="0" y="0">10</tspan></text>
  <text id="_2" data-name="2" transform="translate(37.326 100)" fill="#707070" font-size="20" font-family="SegoeUI, Segoe UI"><tspan x="0" y="0">2</tspan></text>
  <text id="_5" data-name="5" transform="translate(173.674 96.25)" fill="#707070" font-size="20" font-family="SegoeUI, Segoe UI"><tspan x="0" y="0">5</tspan></text>
  <text id="_20" data-name="20" transform="translate(310.522 96)" fill="#707070" font-size="20" font-family="SegoeUI, Segoe UI"><tspan x="0" y="0">20</tspan></text>
  <g id="Ellipse_1" data-name="Ellipse 1" transform="translate(84 22)" stroke="#707070" stroke-width="1">
    <ellipse cx="4" cy="3.5" rx="4" ry="3.5" stroke="none"/>
    <ellipse cx="4" cy="3.5" rx="3.5" ry="3" fill="none"/>
  </g>
  <g id="Ellipse_2" data-name="Ellipse 2" transform="translate(84.326 88)" stroke="#707070" stroke-width="1">
    <ellipse cx="4" cy="3.5" rx="4" ry="3.5" stroke="none"/>
    <ellipse cx="4" cy="3.5" rx="3.5" ry="3" fill="none"/>
  </g>
  <g id="Ellipse_3" data-name="Ellipse 3" transform="translate(220.674 84.25)" stroke="#707070" stroke-width="1">
    <ellipse cx="4" cy="3.5" rx="4" ry="3.5" stroke="none"/>
    <ellipse cx="4" cy="3.5" rx="3.5" ry="3" fill="none"/>
  </g>
  <g id="Ellipse_4" data-name="Ellipse 4" transform="translate(357.522 84)" stroke="#707070" stroke-width="1">
    <ellipse cx="4" cy="3.5" rx="4" ry="3.5" stroke="none"/>
    <ellipse cx="4" cy="3.5" rx="3.5" ry="3" fill="none"/>
  </g>
  <line id="Line_2" data-name="Line 2" x2="50.682" transform="translate(91.992 25.744)" fill="none" stroke="#707070" stroke-width="2"/>
  <line id="Line_4" data-name="Line 4" y1="4.244" x2="50.182" transform="translate(92.318 87.5)" fill="none" stroke="#707070" stroke-width="2"/>
  <line id="Line_6" data-name="Line 6" x2="50.682" transform="translate(228.667 87.994)" fill="none" stroke="#707070" stroke-width="2"/>
  <line id="Line_7" data-name="Line 7" x2="50.682" transform="translate(365.515 87.744)" fill="none" stroke="#707070" stroke-width="2"/>
  <g id="Group_1" data-name="Group 1" transform="translate(-762 -96)">
    <g id="Ellipse_5" data-name="Ellipse 5" transform="translate(904 100)" fill="#fff" stroke="#707070" stroke-width="2">
      <circle cx="21.5" cy="21.5" r="21.5" stroke="none"/>
      <circle cx="21.5" cy="21.5" r="20.5" fill="none"/>
    </g>
    <text id="null" transform="translate(910 130)" fill="#f10a0a" font-size="20" font-family="SegoeUI, Segoe UI"><tspan x="0" y="0">null</tspan></text>
  </g>
  <g id="Group_2" data-name="Group 2" transform="translate(-494.826 -36.25)">
    <g id="Ellipse_5-2" data-name="Ellipse 5" transform="translate(904 100)" fill="#fff" stroke="#707070" stroke-width="2">
      <circle cx="21.5" cy="21.5" r="21.5" stroke="none"/>
      <circle cx="21.5" cy="21.5" r="20.5" fill="none"/>
    </g>
    <text id="null-2" data-name="null" transform="translate(910 130)" fill="#f10a0a" font-size="20" font-family="SegoeUI, Segoe UI"><tspan x="0" y="0">null</tspan></text>
  </g>
</svg>

## Singly Linked List & Doubly Linked List


## Operations
Below are some operations on Linked Lists 

