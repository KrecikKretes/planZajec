let grupy;
let wykladowcy;
let sale;
let plan;
function start() {
    grupy = document.getElementById("grupy");
    wykladowcy = document.getElementById("wykladowcy");
    sale = document.getElementById("sale");
}

function change(){
    document.getElementById("grupy_img_loading").style.width = '0';
    document.getElementById("grupy_img_ok").style.width = "50px";

    let div = document.getElementById("wykladowcy_div");
    const iframe = document.createElement("iframe");
    iframe.src="../wykladowcy/updateWykladowcy";
    iframe.id = "wykladowcy_iframe";
    div.appendChild(iframe);
    $('#wykladowcy_iframe').on( 'load', function() {
        // code will run after iframe has finished loading
       change2()
    } );
}

function change2(){
    document.getElementById("wykladowcy_img_loading").style.width = '0';
    document.getElementById("wykladowcy_img_ok").style.width = "50px";
    let div = document.getElementById("sale_div");
    const iframe = document.createElement("iframe");
    iframe.src="../sale/updateSale";
    iframe.id= "sale_iframe";
    div.appendChild(iframe);
    $('#sale_iframe').on( 'load', function() {
        // code will run after iframe has finished loading
        change3()
    } );
}
function change3(){
    document.getElementById("sale_img_loading").style.width = '0';
    document.getElementById("sale_img_ok").style.width = "50px";
    let div = document.getElementById("plan_div");
    const iframe = document.createElement("iframe");
    iframe.src="../plan/updatePlan";
    iframe.id= "plan_iframe";
    div.appendChild(iframe);
    $('#plan_iframe').on( 'load', function() {
        // code will run after iframe has finished loading
        document.getElementById("plan_img_loading").style.width = '0';
        document.getElementById("plan_img_ok").style.width = "50px";
        alert("End");
        button();
    } );
}

function button(){
    let div = document.getElementById("button_div");
    const button = document.createElement("button");
    button.innerText = "Powrót";
    button.onclick = changePage();
    div.appendChild(button);
}
function changePage(){
    document.location.href = "/complete";
}