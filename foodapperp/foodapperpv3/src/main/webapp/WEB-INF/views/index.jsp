<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/navbar.jsp" %>

<!-- Hero Section -->
<section class="hero-section">
    <div class="hero-overlay">

        <h1 class="display-4 fw-bold">Share Food. Save Lives.</h1>

        <p class="lead">
            Help reduce food waste and feed those in need
        </p>

        <a href="#" class="btn btn-success btn-lg mt-3">
            Donate Food Now
        </a>

    </div>
</section>



<!-- About Section -->
<section class="py-5">

    <div class="container">

        <div class="text-center mb-4">
            <h2>About FoodShare</h2>
            <p class="text-muted">Connecting food donors with people in need</p>
        </div>

        <div class="row align-items-center">

            <div class="col-md-6">
                <img src="https://images.unsplash.com/photo-1606787366850-de6330128bfc"
                     class="img-fluid rounded">
            </div>

            <div class="col-md-6">

                <p>
                    FoodShare is a platform that connects restaurants, hotels,
                    event organizers, and individuals with NGOs and people who
                    need food. Instead of wasting excess food, donate it and
                    help feed hungry communities.
                </p>

                <a href="#" class="btn btn-outline-success">
                    Learn More
                </a>

            </div>

        </div>

    </div>

</section>



<!-- How It Works -->
<section class="bg-light py-5">

    <div class="container">

        <div class="text-center mb-4">
            <h2>How It Works</h2>
        </div>

        <div class="row text-center g-4">

            <div class="col-md-4">

                <div class="card shadow-sm">
                    <img src="https://images.unsplash.com/photo-1544025162-d76694265947"
                         class="card-img-top">

                    <div class="card-body">
                        <h5 class="card-title">Register Donation</h5>
                        <p class="card-text">
                            Donors can register surplus food using our platform.
                        </p>
                    </div>

                </div>

            </div>


            <div class="col-md-4">

                <div class="card shadow-sm">
                    <img src="https://images.unsplash.com/photo-1559027615-cd4628902d4a"
                         class="card-img-top">

                    <div class="card-body">
                        <h5 class="card-title">NGO Pickup</h5>
                        <p class="card-text">
                            Nearby NGOs or volunteers receive the request and collect the food.
                        </p>
                    </div>

                </div>

            </div>


            <div class="col-md-4">

                <div class="card shadow-sm">
                    <img src="https://images.unsplash.com/photo-1593113630400-ea4288922497"
                         class="card-img-top">

                    <div class="card-body">
                        <h5 class="card-title">Food Distribution</h5>
                        <p class="card-text">
                            Food is distributed to homeless shelters and people in need.
                        </p>
                    </div>

                </div>

            </div>

        </div>

    </div>

</section>



<!-- Impact Section -->
<section class="py-5">

    <div class="container text-center">

        <h2 class="mb-4">Our Impact</h2>

        <div class="row">

            <div class="col-md-4">
                <h3>10,000+</h3>
                <p>Meals Donated</p>
            </div>

            <div class="col-md-4">
                <h3>150+</h3>
                <p>NGO Partners</p>
            </div>

            <div class="col-md-4">
                <h3>500+</h3>
                <p>Active Volunteers</p>
            </div>

        </div>

    </div>

</section>



<!-- Contact Section -->
<section class="bg-light py-5">

    <div class="container">

        <div class="text-center mb-4">
            <h2>Contact Us</h2>
        </div>

        <div class="row">

            <div class="col-md-6">

                <h5>Get in Touch</h5>

                <p>Email: support@foodshare.org</p>
                <p>Phone: +91 98765 43210</p>
                <p>Address: Chennai, India</p>

            </div>


            <div class="col-md-6">

                <form>

                    <div class="mb-3">
                        <input type="text" class="form-control"
                               placeholder="Your Name">
                    </div>

                    <div class="mb-3">
                        <input type="email" class="form-control"
                               placeholder="Your Email">
                    </div>

                    <div class="mb-3">
                        <textarea class="form-control"
                                  rows="4"
                                  placeholder="Your Message"></textarea>
                    </div>

                    <button class="btn btn-success">
                        Send Message
                    </button>

                </form>

            </div>

        </div>

    </div>

</section>



<%@ include file="../layout/footer.jsp" %>