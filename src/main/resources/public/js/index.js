alert("connected!!")


function myFunction() {
  // Declare variables
  var input, filter, table, tr, td0,td1,td2, td3, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  // TODO: fix the bug..  to try to make all if conditions work propely
  //  you can only search for  names wich is the second index..
  for (i = 0; i < tr.length; i++) {

    td1 = tr[i].getElementsByTagName("td")[1];



     if (td1) {
      txtValue = td1.textContent || td1.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }

  }
}