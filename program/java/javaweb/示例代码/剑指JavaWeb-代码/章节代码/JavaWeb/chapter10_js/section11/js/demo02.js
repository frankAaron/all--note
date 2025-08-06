window.onload = function () {
	updateZJ();
	//当页面加载完成，需要绑定事件
	//根据id获取表格（table对象）
	var fruitTbl = document.getElementById("tbl_fruit");
	//获取表格中的所有行
	var rows = fruitTbl.rows;
	for(var i = 1; i < rows.length-1; i++){
		var tr = rows[i];
		//1.绑定鼠标悬浮以及离开时设置背景颜色事件
		tr.onmouseover = showBGColor;
		tr.onmouseout = clearBGColor;
		//获取tr这一行的所有单元格
		var cells = tr.cells;
		var priceTD = cells[1];
		//2.绑定鼠标悬浮在单价单元格变手势的事件
		priceTD.onmouseover = showHand;
		//3.绑定鼠标点击单价单元格事件
		priceTD.onclick = editPrice;
		
	}
	
}

//当鼠标点击单价单元格时进行价格编辑
function editPrice(){
	if(event && event.srcElement && event.srcElement.tagName=="TD"){
		var priceTD = event.srcElement;
		//判断当前priceTD是否有子节点，而且第一个子节点是文本节点，TextNode对应3，ElementNode对应1
		if(priceTD.firstChild && priceTD.firstChild.nodeType==3){
			//innerText表示设置或者获取当前节点的内部文本
			var oldPrice = priceTD.innerText;
			//innerHTML表示设置当前节点的内部HTML
			priceTD.innerHTML = "<input type='text' size='4'/>";
			//呈现的效果即<td><input type='text' size='4'/></td>
			var input = priceTD.firstChild;
			if(input.tagName=="INPUT"){
				input.value = oldPrice;
				//选中输入框内部的文本
				input.select();
				//4.绑定输入框失去焦点事件，失去焦点时更新单价
				input.onblur = updatePrice;
				
				//7.在输入框上绑定键盘按下的事件，此处需要保证用户输入的是数字
				input.onkeydown = ckInput;
			}
		}
	}
}

//检验键盘按下的值是否为数字
function ckInput(){
	var kc = event.keyCode;
	//0~9对应ASCII码为48~57；backspace对应8；enter对应13；
	console.log(kc);
	if(!((kc>=48 && kc<=57) || kc==8 || kc==13)){
		event.returnValue = false;
	}
	//输入值后按下回车键触发失去焦点事件
	if(kc == 13){
		event.srcElement.blur();
	}
}

//失去焦点时更新单价
function updatePrice(){
	if(event && event.srcElement && event.srcElement.tagName=="INPUT"){
		var input = event.srcElement;
		var newPrice = input.value;
		//input节点的父节点是td
		var priceTD = input.parentElement;
		priceTD.innerText = newPrice;
		
		//5.更新当前行的小计这一格子的值
		//priceTD.parentElement td的父元素是tr
		updateXJ(priceTD.parentElement);
	}
}

//更新指定行的小计
function updateXJ(tr){
	if(tr && tr.tagName=="TR"){
		var tds = tr.cells;
		var price = tds[1].innerText;
		var count = tds[2].innerText;
		//innerText获取到的值的类型是字符串类型，因此需要类型转换，才能进行数学运算
		var xj = parseInt(price) * parseInt(count);
		tds[3].innerText = xj;
		
		//6.更新总计
		updateZJ();
	}
}

//更新总计
function updateZJ(){
	var fruitTbl = document.getElementById("tbl_fruit");
	var rows = fruitTbl.rows;
	var sum = 0;
	for(var i = 1; i < rows.length-1; i++){
		var tr = rows[i];
		var xj = parseInt(tr.cells[3].innerText);//NaN (not a number)
		sum = sum + xj;
	}
	rows[rows.length-1].cells[1].innerText = sum;
}


//当鼠标悬浮时，显示背景颜色
function showBGColor(){
	
	//event ：当前发生的事件
	//event.srcElement ：事件源
	//alert(event.srcElement)
	//alert(event.srcElement.tagName) --> TD
	if (event && event.srcElement && event.srcElement.tagName=="TD"){
		var td = event.srcElement;
		//td.parentElement  表示获取td的父元素  -->TR
		var tr = td.parentElement;
		//如果想要通过js代码设置某节点的样式，则需要加上.style
		tr.style.backgroundColor = "navy";
		
		//tr.cells表示获取这个tr中的所有的单元格
		var tds = tr.cells;
		for(var i = 0; i < tds.length; i++){
			
			tds[i].style.color = "white";
		}
	}
}

//当鼠标离开时，恢复原始样式
function clearBGColor(){
	
	if(event && event.srcElement && event.srcElement.tagName == "TD"){
		
		var td = event.srcElement;
		var tr = td.parentElement;
		tr.style.backgroundColor = "transparent";//透明色
		
		var tds = tr.cells;
		for(var i = 0; i < tds.length; i++){
			tds[i].style.color = "darkslategrey";
		}
	}
	
}

//当鼠标悬浮在单价单元格时，显示手势
function showHand(){
	if(event && event.srcElement && event.srcElement.tagName == "TD"){
		var td = event.srcElement;
		//cursor：光标
		td.style.cursor = "hand";
	}
}