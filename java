        // Mobile Menu Toggle
        const menuToggle = document.querySelector('.menu-toggle');
        const navLinks = document.querySelector('.nav-links');

        menuToggle.addEventListener('click', function() {
            navLinks.classList.toggle('active');
        });

        // Dropdown Toggle for Mobile Only
        const dropdownButtons = document.querySelectorAll('.drop-btn');

        dropdownButtons.forEach(button => {
            button.addEventListener('click', function(e) {
                // Only toggle on mobile (screen width < 768px)
                if (window.innerWidth < 768) {
                    e.stopPropagation();
                    const dropdown = this.closest('.dropdown');
                    
                    // Close other dropdowns
                    document.querySelectorAll('.dropdown').forEach(dd => {
                        if (dd !== dropdown) {
                            dd.classList.remove('active');
                        }
                    });
                    
                    // Toggle current dropdown
                    dropdown.classList.toggle('active');
                }
            });
        });

        // Close dropdowns when clicking outside (mobile only)
        document.addEventListener('click', function(event) {
            if (window.innerWidth < 768) {
                const isClickInsideNav = event.target.closest('nav');
                if (!isClickInsideNav) {
                    document.querySelectorAll('.dropdown').forEach(dropdown => {
                        dropdown.classList.remove('active');
                    });
                    // Close mobile menu if clicking outside
                    if (navLinks.classList.contains('active')) {
                        navLinks.classList.remove('active');
                    }
                }
            }
        });

        // Clean up on window resize
        window.addEventListener('resize', function() {
            if (window.innerWidth >= 768) {
                // Remove active class from dropdowns on desktop
                document.querySelectorAll('.dropdown').forEach(dropdown => {
                    dropdown.classList.remove('active');
                });
            }
        });