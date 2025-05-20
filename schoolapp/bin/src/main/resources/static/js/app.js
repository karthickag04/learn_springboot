// Simple JS to make the navigation links smooth scroll
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const targetElement = document.querySelector(this.getAttribute('href'));
        window.scrollTo({
            top: targetElement.offsetTop - 50, // Add a little offset for better visibility
            behavior: 'smooth'
        });
    });
});

// Example of a simple DOM manipulation (showing alert on contact section click)
document.getElementById('contact').addEventListener('click', function () {
    alert('Contact section clicked!');
});
