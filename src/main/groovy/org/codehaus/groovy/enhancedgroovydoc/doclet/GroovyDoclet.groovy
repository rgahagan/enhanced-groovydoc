package org.codehaus.groovy.enhancedgroovydoc.doclet

import java.util.Vector;



import org.apache.tools.ant.ProjectComponent;
import org.apache.tools.ant.types.Path 

/**
 * Probando un tag grande de documentacion
 * @author Isidoro Treviño
 * @sequence.diagram	      
	bfs:BFS[a]
	/queue:FIFO
	someNode:Node
	node:Node
	adjList:List
	adj:Node
	
	bfs:queue.new
	bfs:someNode.setLevel(0)
	bfs:queue.insert(someNode)
	[c:loop while queue != ()]
	  bfs:node=queue.remove()
	  bfs:level=node.getLevel()
	  bfs:adjList=node.getAdjacentNodes()
	  [c:loop 0 <= i < #adjList]
	    bfs:adj=adjList.get(i)
	    bfs:nodeLevel=adj.getLevel()
	    [c:alt nodeLevel IS NOT defined]
	      bfs:adj.setLevel(level+1)
	      bfs:queue.insert(adj)
	      --[else]
	      bfs:nothing to do
	    [/c]
	  [/c]
	[/c]
	bfs:queue.destroy() 
	
	@version 1.2
 */
class GroovyDoclet extends ProjectComponent {
	
	String name
	
	/**
	 * Un javadoc de atributo
	 * 
	 */
	Path path
	
	Vector params = new Vector()
	
	/**
	 * Un doclet de metodo
	 * @param path
	 */
	public void setPath(Path path) {
		if (this.path == null) {
			this.path = path;
		} else {
			this.path.append(path);
		}
	}
	
	/**
	 * Otro javadoc de metodo
	 * @return el Path
	 * @sequence.diagram
	 	user:Actor
		server:Server[a]
		job:BackgroundJob[a]
		db:Database[a]
		
		user:server[s].start
		      
		
		# Here comes the asynchronous message that implicitly spawns
		# a new thread. Thanks to the mnemnonic 'j' the job object
		# can safely be identified on that new thread, so
		# you do not even have to deal with thread numbers.
		
		[c asynchronous message]
		  server:>job[j].start
		[/c]
		
		job:db.do 1'000'000 queries
		server[s]:server.do something useful
		job[j]:job.analyze queries
		job[j]:job.compute result
		server[s]:server.wait for result
		job[j]:server.send back result
		job[j]:stop
		server[s]:user.send result to user
	 */
	public Path createPath() {
		if (path == null) {
			path = new Path(getProject());
		}
		return path.createPath();
	}
	
	public void setPathRef(Reference r) {
		createPath().setRefid(r);
	}
	
	public GroovyDocletParam createParam() {
		GroovyDocletParam param = new GroovyDocletParam();
		params.addElement(param)		
		return param;
	}
		
	/**
	* Get the doclet's parameters.
	*
	* @return an Enumeration of DocletParam instances.
	*/
	public Enumeration getParams() {
		return params.elements();
	}
	
	public String[][] asOptions(){
		String[][] options = new String[params.size()][]
		for(int i=0;i<params.size();i++){
			options[i] = [params.elementAt(i).name,params.elementAt(i).value].findAll{ it!=null } as String[]
		}
		return options
	}
}
