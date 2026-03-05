<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/navbar.jsp" %>

<!-- Hero Section -->
<section class="hero-section">

    <div class="hero-overlay">

        <h2 class="mb-4">Donate Food</h2>

        <form class="text-start">

            <div class="mb-3">
                <label class="form-label text-white">Your Name</label>
                <input type="text" class="form-control" placeholder="Enter your name">
            </div>

            <div class="mb-3">
                <label class="form-label text-white">Phone Number</label>
                <input type="tel" class="form-control" placeholder="Enter phone number">
            </div>

            <div class="mb-3">
                <label class="form-label text-white">Food Type</label>
                <select class="form-control">
                    <option>Cooked Food</option>
                    <option>Packed Food</option>
                    <option>Groceries</option>
                    <option>Vegetables</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label text-white">Pickup Address</label>
                <textarea class="form-control" rows="3" placeholder="Enter pickup location"></textarea>
            </div>

            <div class="mb-3">
                <label class="form-label text-white">Quantity</label>
                <input type="text" class="form-control" placeholder="Ex: 20 meals">
            </div>

            <div class="text-center">
                <button class="btn btn-success w-100">
                    Submit Donation
                </button>
            </div>

        </form>

    </div>

</section>


<%@ include file="../layout/footer.jsp" %>