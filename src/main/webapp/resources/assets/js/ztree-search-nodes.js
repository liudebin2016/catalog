var nodeList = [];
function searchNode(e){
		var zTree = jq1_4.fn.zTree.getZTreeObj("officeTree");
	var value = $.trim($('#searchNodes').val());
	if (value === "") {
        zTree.showNodes(zTree.transformToArray(zTree.getNodes())) ;
        return;
    }
	nodeList = zTree.getNodesByParamFuzzy('name', value);
	nodeList = zTree.transformToArray(nodeList);
    updateNodes(true);
}
function updateNodes(highlight) {
    var zTree = jq1_4.fn.zTree.getZTreeObj("officeTree");
    var allNode = zTree.transformToArray(zTree.getNodes());
    zTree.hideNodes(allNode);
    for(var n in nodeList){
        findParent(zTree,nodeList[n]);
    }
    zTree.showNodes(nodeList);
}
function findParent(zTree,node){
    zTree.expandNode(node,true,false,false);
    var pNode = node.getParentNode();
    if(pNode != null){
        nodeList.push(pNode);
        findParent(zTree,pNode);
    }
}