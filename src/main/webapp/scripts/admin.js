function confirmLogOut() {
    const confirmation = confirm("Are you sure you want to Logout.");
    if(confirmation) return true;
    else return false;
}

let formToDelete;

function showPopup(form) {
    formToDelete = form; // Store the form reference
    document.getElementById("myModal").style.display = "block"; // Show the modal
}

function closePopup() {
    document.getElementById("myModal").style.display = "none"; // Hide the modal
}

document.getElementById("confirmDeleteButton").onclick = function() {
    if (formToDelete) {
        formToDelete.submit(); // Submit the stored form
    }
    closePopup(); // Hide the modal
};
