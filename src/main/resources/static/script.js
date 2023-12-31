$(document).ready(function() {
function getAllBooks(){
    $.ajax({
        type:"GET",
        url:"/admin/show/all",
        success:function(books){
            updateTable(books);
        },
        error:function(error){
            console.error("Error getting all books: ",error);
        }
    });
}

function addBook() {
    var isbn=document.getElementById("isbn").value;
    var name=document.getElementById("bookName").value;
    var author=document.getElementById("authorName").value;
    var issue_date=document.getElementById("issueDate").value;
    var charge=document.getElementById("copies").value;

    var book={
        isbn:isbn,
        name:name,
        author:author,
        issue_date:issue_date,
        copies:copies
    };

    console.log("Request Data:", JSON.stringify(book));

    $.ajax({
        type:"POST",
        contentType:"application/json",
        url:"/admin/add",
        data:JSON.stringify(book),
        success:function(){
            getAllBooks();
        },
        error:function(error){
            console.error("Error adding book: ",error);
        }
    });
}

// Search functions
function searchByIsbn() {
    var isbn=document.getElementById("searchIsbn").value;
    $.ajax({
        type:"GET",
        url:"/admin/show/",
        data:JSON.stringify(isbn),
        success:function(book){
            updateTable(book);
        },
        error:function(error){
            console.error("Error searching book by ISBN: ",error);
        }
    });
}

function searchByName() {
    var name=document.getElementById("searchName").value;
        $.ajax({
            type:"GET",
            url:"/admin/show/name/"+name,
            success:function(books){
                updateTable(books);
            },
            error:function(error){
                console.error("Error searching book by name: ",error);
            }
        });
}

function searchByAuthor() {
    var author=document.getElementById("searchAuthor").value;
            $.ajax({
                type:"GET",
                url:"/admin/show/author/"+author,
                success:function(books){
                    updateTable(books);
                },
                error:function(error){
                    console.error("Error searching book by author: ",error);
                }
            });
}

function searchByDuration() {
    var start=document.getElementById("searchByDurationStart").value;
    var end=document.getElementById("searchByDurationEnd").value;
                $.ajax({
                    type:"GET",
                    url:"/admin/show/duration/"+start+"/"+end,
                    success:function(books){
                        updateTable(books);
                    },
                    error:function(error){
                        console.error("Error searching book by duration: ",error);
                    }
                });
}

// Remove book function
function removeBook(isbn) {
console.log("removeBook called");
    $.ajax({
        type: "DELETE",
        url:"/admin/del/"+isbn,
        success: function () {
            getAllBooks();
        },
        error: function (error) {
            console.error("Error removing book:", error);
        }
    });
}

// Update html table
function updateTable(books) {
    var bookTable = document.getElementById("bookTable");
    bookTable.innerHTML = "";

    for (var i = 0; i < books.length; i++) {
        var book = books[i];

        var newRow = bookTable.insertRow(-1);

        var cell1 = newRow.insertCell(0);
        var cell2 = newRow.insertCell(1);
        var cell3 = newRow.insertCell(2);
        var cell4 = newRow.insertCell(3);
        var cell5 = newRow.insertCell(4);
        var cell6 = newRow.insertCell(5);

        cell1.innerHTML = book.isbn;
        cell2.innerHTML = book.name;
        cell3.innerHTML = book.author;
        cell4.innerHTML = book.issue_date;
        cell5.innerHTML = book.copies;

        var removeButton = document.createElement("button");
        removeButton.type = "button";
        removeButton.classList.add("removeBookButton");
        removeButton.setAttribute("data-isbn", book.isbn);
        removeButton.innerHTML = "Remove";
        cell6.appendChild(removeButton);

        $(document).on("click", ".removeBookButton", function() {
            var isbn = $(this).data("isbn");
            removeBook(isbn);
        });
    }
}

// Call getAllBooks initially to load existing data
getAllBooks();

    $("#getAllBooksButton").click(getAllBooks);
    $("#addBookButton").click(addBook);
    $("#searchIsbnButton").click(searchByIsbn);
    $("#searchNameButton").click(searchByName);
    $("#searchAuthorButton").click(searchByAuthor);
    $("#searchByDurationButton").click(searchByDuration);
});