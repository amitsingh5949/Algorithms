package symphony;

import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class Problem1 {

	/**
	 * You should implement this method to solve this task.
	 * Your method should look through allProjects and updates and return only the Projects that are affected
	 * by the Updates.   A Project is affected by an Update if at least 1 Component in the Project also appears
	 * in the Update.
	 **/
	public Set<Project> findProjectsRequiringUpdates(Set<Project> allProjects, Set<Update> updates) {

		Set<Project> result = new HashSet<>();

		Map<Component, Project> map = new HashMap<>();

		for(Project p : allProjects) {
			Set<Component> components = p.getComponents();
			for(Component c : components) {
				map.put(c, p);
			}
		}

		for(Update u : updates) {
			Set<Component> components = u.getComponents();
			for(Component c : components) {
				if(map.get(c) != null) {
					result.add(map.get(c));
				}
			}
		}

		return result;

	}

	//The following 3 classes can be looked at to help understand the problem.   Do not change any code below this line.
	//Any changes made below this line will result in failure.

	/**
	 * Component Class - Do not Change, but you can use this to help understand the problem.   Changing this 
	 * will likely result in failure.
	 **/
	static class Component { 

		//The ID of the component
		private final int id;

		public Component(int id) { 
			this.id = id;
		}

		//Retrieve the ID
		public int getId() {
			return id;
		}

		public String toString() { 
			return "(C, " + id + ")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Component other = (Component) obj;
			if (id != other.id)
				return false;
			return true;
		}


	}

	/**
	 * Project Class
	 * 
	 * Do not Change, but you can use this to help understand the problem.   
	 * Changing this will likely result in failure.
	 **/
	static class Project { 

		//The Project ID
		private final int id;

		//The Components that make up this Project
		private final Set<Component> components;

		public Project(int id, Set<Component> components) {
			this.id = id;
			this.components = components;
		}

		/**
		 * Get the Project ID
		 **/
		public int getId() {
			return id;
		}

		/**
		 * Access the Components in this Project
		 **/
		public Set<Component> getComponents() {
			return components;
		}

		public String toString() {
			StringBuffer buffer = new StringBuffer("(P, ");
			buffer.append(id);
			if(!components.isEmpty()) { 
				buffer.append(", ");
				buffer.append(components.stream().map(Component::toString).collect(Collectors.joining(", ")));
			}
			buffer.append(")");
			return buffer.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((components == null) ? 0 : components.hashCode());
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Project other = (Project) obj;
			if (components == null) {
				if (other.components != null)
					return false;
			} else if (!components.equals(other.components))
				return false;
			if (id != other.id)
				return false;
			return true;
		}

	}


	/**
	 * Update Class
	 * 
	 * Do not Change this Class, doing so will result in failure.
	 **/
	static class Update { 

		private final int id;
		private final Set<Component> components;

		public Update(int id, Set<Component> components) {
			this.id = id;
			this.components = components;
		}

		public int getId() {
			return id;
		}
		public Set<Component> getComponents() {
			return components;
		}

		public String toString() {
			StringBuffer buffer = new StringBuffer("(U, ");
			buffer.append(id);
			if(!components.isEmpty()) { 
				buffer.append(", ");
				buffer.append(components.stream().map(Component::toString).collect(Collectors.joining(", ")));
			}
			buffer.append(")");
			return buffer.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((components == null) ? 0 : components.hashCode());
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Update other = (Update) obj;
			if (components == null) {
				if (other.components != null)
					return false;
			} else if (!components.equals(other.components))
				return false;
			if (id != other.id)
				return false;
			return true;
		}
	}

	//////////////////////////////////////////////////
	//  Do Not Change any Code below this line
	//  All Code from here on is used for Serializing/Deserializing Test Cases and Results to and from String format
	//////////////////////////////////////////////////

	public String solution(String S) {
		//Do not change these lines, they parse the test case into objects for you
		TestCase t = Problem1.makeTestCase(S);
		Set<Project> allProjects = t.getAllProjects();
		Set<Update> updates = t.getUpdates();

		//You need to fill this Set with the Projects that must be updated
		Set<Project> results = findProjectsRequiringUpdates(allProjects, updates);

		//This will change the Project set back to a String, do not change this
		return Problem1.projectSetToString(results);
	}


	static class TestCase { 

		private  Set<Project> allProjects;
		private  Set<Update> updates;

		public TestCase(Set<Project> allProjects, Set<Update> updates) { 
			this.allProjects = allProjects;
			this.updates = updates;
		}

		public Set<Project> getAllProjects() {
			return allProjects;
		}

		public Set<Update> getUpdates() {
			return updates;
		}

	}

	static class Token  { 
		String t;
		String id;

		public Token(String t, String id) { 
			this.t = t;
			this.id = id;
		}

		public String getType() { 
			return t;
		}

		public String getId() { 
			return id;
		}
	}

	static class NonTerminal extends Token { 
		List<Token> children;

		public NonTerminal(String type, String id, List<Token> children) { 
			super(type, id);
			this.children = children;
		}

		public List<Token> getChildren() { 
			return children;
		}
	}

	public static TestCase makeTestCase(String s) { 
		List<Token> tokens = tokenize(s);
		Set<Project> projects = new HashSet<Project>();
		Set<Update> updates = new HashSet<Update>();

		for(Token curToken: tokens) { 
			if(curToken.getType().equals("P")) { 
				NonTerminal curNonTerminal = (NonTerminal) curToken;

				Set<Component> components = curNonTerminal.getChildren().stream()
						.map( cur -> new Component(Integer.parseInt(cur.getId())))
						.collect(Collectors.toSet());
				int id = Integer.parseInt(curNonTerminal.getId());
				projects.add(new Project(id, components));
			}

			if(curToken.getType().equals("U")) { 
				NonTerminal curNonTerminal = (NonTerminal) curToken;

				Set<Component> components = curNonTerminal.getChildren().stream()
						.map( cur -> new Component(Integer.parseInt(cur.getId())))
						.collect(Collectors.toSet());
				int id = Integer.parseInt(curNonTerminal.getId());
				updates.add(new Update(id, components));
			}

		}

		return new TestCase(projects, updates);
	}

	public static Set<Project> makeExpectedSolutionSet(String s) {
		Set<Project> retval = new HashSet<>();
		tokenize(s).stream().forEach(t -> { 
			NonTerminal curNonTerminal = (NonTerminal) t;

			Set<Component> components = curNonTerminal.getChildren().stream()
					.map( cur -> new Component(Integer.parseInt(cur.getId())))
					.collect(Collectors.toSet());
			retval.add(new Project(Integer.parseInt(t.getId()), components));
		});

		return retval;
	}

	public static List<Token> tokenize(String s) { 
		List<String> tokenCandidates = parse(s);
		List<String> curTokenPieces = new ArrayList<>();
		List<Token> results = new ArrayList<>();
		List<Token> curChildren = new ArrayList<>();
		for(String cur: tokenCandidates) { 
			if(cur.contains("(")) { 
				curChildren.add(tokenize(cur).get(0));
			} else { 
				//Pieces of a token
				if(curTokenPieces.isEmpty() || !isTokenStart(cur)) { 
					curTokenPieces.add(cur);
				} else { 
					results.add(makeToken(curTokenPieces, curChildren)); 
					curTokenPieces = new ArrayList<>();
					curChildren = new ArrayList<>();
					curTokenPieces.add(cur);
				}
			}
		}

		if(!curTokenPieces.isEmpty()) { 
			results.add(makeToken(curTokenPieces, curChildren));
			curChildren.clear();
		}

		curChildren.stream().forEach(c -> results.add(c));



		return results;
	}

	public static Token makeToken(List<String> pieces, List<Token> prefoundChildren) { 
		if(pieces.isEmpty()) { 
			return null;
		}
		String type = pieces.get(0);
		String id = pieces.get(1);
		List<Token> children = new ArrayList<>(prefoundChildren);
		if(pieces.size() > 2) {  
			for(int i=2;i<pieces.size(); i++) { 
				Token nested = makeToken(pieces.subList(2, pieces.size()-1), new ArrayList<>());
				children.add(nested);
			}
		}
		if(children.isEmpty()) { 
			return new Token(type, id);
		} else { 
			return new NonTerminal(type, id, children);
		}
	}

	public static boolean isTokenStart(String cur) { 
		return cur.equals("C") || cur.equals("P") || cur.equals("U");
	}

	public static List<String> parse(String s) {
		String inner = stripParens(s);
		List<String> result = new ArrayList<>();
		if(inner.length()==0)
			return result;

		StringBuffer curToken = new StringBuffer();
		int parenDepth = 0;
		for(int i=0;i<inner.length(); i++) { 
			char curChar =  inner.charAt(i);
			//Case 1 - not in nested object
			if(!Character.isWhitespace(curChar) && !isComma(curChar) && !isParen(curChar) && (parenDepth==0)) { 
				curToken.append(curChar);
			}

			//Case 2 - end of current object
			if(isComma(curChar) && (parenDepth==0)) {
				result.add(curToken.toString());
				curToken = new StringBuffer();
			}

			if(isParen(curChar)) { 
				if(isOpenParen(curChar)) {
					++parenDepth;
				} else { 
					--parenDepth;
				}
				curToken.append(curChar);
			}

			if(!Character.isWhitespace(curChar) && !isParen(curChar) && (parenDepth !=0)) { 
				curToken.append(curChar);

			}
		}

		//End of string - last result needs to be added
		result.add(curToken.toString());

		return result;
	}

	public static boolean isParen(char c) { 
		return (isOpenParen(c) || isCloseParen(c));
	}

	public static boolean isOpenParen(char c) { 
		return (c == '(');
	}

	public static  boolean isCloseParen(char c) { 
		return (c == ')');
	}

	public static boolean isComma(char c) { 
		return (c == ',');
	}

	public static String stripParens(String in) { 
		return in.substring(1, in.length() - 1);
	}

	static String projectSetToString(Set<Project> input) { 
		StringBuffer buffer = new StringBuffer("(");
		buffer.append(input.stream().map(Project::toString).collect(Collectors.joining(", ")));
		buffer.append(")");
		return buffer.toString();
	}

}
