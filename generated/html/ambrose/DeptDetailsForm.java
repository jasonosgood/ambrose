package ambrose;

import martini.model.*;

public class 
	DeptDetailsForm
extends 
	Form<Dept>
{
	private Object _abbrev = null;
	public Object getAbbrev() { return _abbrev; }
	public void setAbbrev( Object abbrev ) { _abbrev = abbrev; }

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

	private Object _startYear = null;
	public Object getStartYear() { return _startYear; }
	public void setStartYear( Object startYear ) { _startYear = startYear; }

	private Object _endYear = null;
	public Object getEndYear() { return _endYear; }
	public void setEndYear( Object endYear ) { _endYear = endYear; }

	private boolean _gened_is = false;
	public boolean getGened_is() { return _gened_is; }
	public void setGened_is( boolean gened_is ) { _gened_is = gened_is; }

	private boolean _gened_nw = false;
	public boolean getGened_nw() { return _gened_nw; }
	public void setGened_nw( boolean gened_nw ) { _gened_nw = gened_nw; }

	private boolean _gened_vpla = false;
	public boolean getGened_vpla() { return _gened_vpla; }
	public void setGened_vpla( boolean gened_vpla ) { _gened_vpla = gened_vpla; }

	private boolean _gened_writing = false;
	public boolean getGened_writing() { return _gened_writing; }
	public void setGened_writing( boolean gened_writing ) { _gened_writing = gened_writing; }

	private boolean _gened_div = false;
	public boolean getGened_div() { return _gened_div; }
	public void setGened_div( boolean gened_div ) { _gened_div = gened_div; }

	private boolean _gened_comp = false;
	public boolean getGened_comp() { return _gened_comp; }
	public void setGened_comp( boolean gened_comp ) { _gened_comp = gened_comp; }

	private boolean _gened_qsr = false;
	public boolean getGened_qsr() { return _gened_qsr; }
	public void setGened_qsr( boolean gened_qsr ) { _gened_qsr = gened_qsr; }

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

	private Select _credits = new Select();
	public Select getCredits() { return _credits; }
	public void setCredits( Select credits ) { _credits = credits; }

	private Select _grading = new Select();
	public Select getGrading() { return _grading; }
	public void setGrading( Select grading ) { _grading = grading; }

	private Select _startTerm = new Select();
	public Select getStartTerm() { return _startTerm; }
	public void setStartTerm( Select startTerm ) { _startTerm = startTerm; }

	private Select _endTerm = new Select();
	public Select getEndTerm() { return _endTerm; }
	public void setEndTerm( Select endTerm ) { _endTerm = endTerm; }

	private Object _description = null;
	public Object getDescription() { return _description; }
	public void setDescription( Object description ) { _description = description; }

}
