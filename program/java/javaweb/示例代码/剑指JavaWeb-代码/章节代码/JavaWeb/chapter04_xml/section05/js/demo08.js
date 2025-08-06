window.onload = function () {
	//��ҳ�������ɣ���Ҫ���¼�
	//����id��ȡ���table����
	var fruitTbl = document.getElementById("tb1_fruit");
	//��ȡ����е�������
	var rows = fruitTbl.rows;
	for(var i = 1; i < rows.length-1; i++){
		var tr = rows[i];
		//1.����������Լ��뿪ʱ���ñ�����ɫ�¼�
		tr.onmouseover = showBGColor;
		tr.onmouseout = clearBGColor;
		//��ȡtr��һ�е����е�Ԫ��
		var cells = tr.cells;
		var priceTD = cells[1];
		//2.����������ڵ��۵�Ԫ������Ƶ��¼�
		priceTD.onmouseover = showHand;
	}
	
}

//���������ʱ����ʾ������ɫ
function showBGColor(){
	
	//event ����ǰ�������¼�
	//event.srcElement ���¼�Դ
	//alert(event.srcElement)
	//alert(event.srcElement.tagName) --> TD
	if (event && event.srcElement && event.srcElement.tagName=="TD"){
		var td = event.srcElement;
		//td.parentElement  ��ʾ��ȡtd�ĸ�Ԫ��  -->TR
		var tr = td.parentElement;
		//�����Ҫͨ��js��������ĳ�ڵ����ʽ������Ҫ����.style
		tr.style.backgroundColor = "navy";
		
		//tr.cells��ʾ��ȡ���tr�е����еĵ�Ԫ��
		var tds = tr.cells;
		for(var i = 0; i < tds.length; i++){
			
			tds[i].style.color = "white";
		}
	}
}

//������뿪ʱ���ָ�ԭʼ��ʽ
function clearBGColor(){
	
	if(event && event.srcElement && event.srcElement.tagName == "TD"){
		
		var td = event.srcElement;
		var tr = td.parentElement;
		tr.style.backgroundColor = "transparent";//͸��ɫ
		
		var tds = tr.cells;
		for(var i = 0; i < tds.length; i++){
			tds[i].style.color = "darkslategrey";
		}
	}
	
}

//����������ڵ��۵�Ԫ��ʱ����ʾ����
function showHand(){
	if(event && event.srcElement && event.srcElement.tagName == "TD"){
		var td = event.srcElement;
		//cursor�����
		td.style.cursor = "hand";
	}
}