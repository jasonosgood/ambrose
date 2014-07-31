package ambrose;

import martini.model.*;

public class 
	DetailsDetailsForm
extends 
	Form<Details>
{
	private Object _number = null;
	public Object getNumber() { return _number; }
	public void setNumber( Object number ) { _number = number; }

	private Object _catalog = null;
	public Object getCatalog() { return _catalog; }
	public void setCatalog( Object catalog ) { _catalog = catalog; }

	private Object _transcript = null;
	public Object getTranscript() { return _transcript; }
	public void setTranscript( Object transcript ) { _transcript = transcript; }

	private Object _creditsMin = null;
	public Object getCreditsMin() { return _creditsMin; }
	public void setCreditsMin( Object creditsMin ) { _creditsMin = creditsMin; }

	private Object _creditsMax = null;
	public Object getCreditsMax() { return _creditsMax; }
	public void setCreditsMax( Object creditsMax ) { _creditsMax = creditsMax; }

	private Object _creditsRepeatable = null;
	public Object getCreditsRepeatable() { return _creditsRepeatable; }
	public void setCreditsRepeatable( Object creditsRepeatable ) { _creditsRepeatable = creditsRepeatable; }

	private Object _startYear = null;
	public Object getStartYear() { return _startYear; }
	public void setStartYear( Object startYear ) { _startYear = startYear; }

	private Object _endYear = null;
	public Object getEndYear() { return _endYear; }
	public void setEndYear( Object endYear ) { _endYear = endYear; }

	private boolean _publish = false;
	public boolean getPublish() { return _publish; }
	public void setPublish( boolean publish ) { _publish = publish; }

	private Object _instructors = null;
	public Object getInstructors() { return _instructors; }
	public void setInstructors( Object instructors ) { _instructors = instructors; }

	private Object _id = null;
	public Object getId() { return _id; }
	public void setId( Object id ) { _id = id; }

	private Select _campus = new Select();
	public Select getCampus() { return _campus; }
	public void setCampus( Select campus ) { _campus = campus; }

	private Select _college = new Select();
	public Select getCollege() { return _college; }
	public void setCollege( Select college ) { _college = college; }

	private Select _dept = new Select();
	public Select getDept() { return _dept; }
	public void setDept( Select dept ) { _dept = dept; }

	private Select _curric = new Select();
	public Select getCurric() { return _curric; }
	public void setCurric( Select curric ) { _curric = curric; }

	private Select _credits = new Select();
	public Select getCredits() { return _credits; }
	public void setCredits( Select credits ) { _credits = credits; }

	private Select _grading = new Select();
	public Select getGrading() { return _grading; }
	public void setGrading( Select grading ) { _grading = grading; }

	private Select _terms = new Select();
	public Select getTerms() { return _terms; }
	public void setTerms( Select terms ) { _terms = terms; }

	private Select _years = new Select();
	public Select getYears() { return _years; }
	public void setYears( Select years ) { _years = years; }

	private Select _geneds = new Select();
	public Select getGeneds() { return _geneds; }
	public void setGeneds( Select geneds ) { _geneds = geneds; }

	private Object _description = null;
	public Object getDescription() { return _description; }
	public void setDescription( Object description ) { _description = description; }

}
