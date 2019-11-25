//Funcion que invoca al grafo
function grafo(){
var gr = new sigma(
  //Configuracion del grafo
    {
      renderer: {
        container: document.getElementById('sigma-container'),
        type: 'canvas'
      },
      settings: {
       minEdgeSize: 0.1,
       maxEdgeSize: 2,
       minNodeSize: 1,
       maxNodeSize: 30,
      }
    }
  );
  
  //Se define el objeto graph el cual consiste un una lista de nodos y
  //otra de aristas
  var graph = {
    nodes: [
      { id: "nd0", label: "Lex Luthor", x: 0, y: 0, size: 30, color: 'green' },
      { id: "nd1", label: "Han Solo", x: 3, y: 1, size: 30, color: 'grey' },
      { id: "nd2", label: "Thanos", x: 1, y: 3, size: 30, color: 'purple' }
    ],
    edges: [
      { id: "ed0", source: "nd0", target: "nd1", color: 'black', type:'arrow', size:2, label:"4 min"},
      { id: "ed1", source: "nd1", target: "nd0", color: 'black', type:'arrow', size:2, label:"11 min"},
      { id: "ed2", source: "nd2", target: "nd0", color: 'black', type:'arrow', size:2, label:"34 min"}
    ]
  }
  
  //Fuciones encargadas de dibujar el grafo
  gr.graph.read(graph);
  gr.refresh();
}