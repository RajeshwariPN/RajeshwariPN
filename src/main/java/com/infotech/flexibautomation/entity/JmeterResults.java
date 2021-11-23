package com.infotech.flexibautomation.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jmeter_results")
public class JmeterResults {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "Label")
	private String label;
	
	@Column(name = "Samples")
	private Integer samples;
	
	@Column(name = "Average")
	private Float average;
	
	@Column(name = "90_Percent")
	private Float NintyPercent;
	
	@Column(name = "Min")
	private  Float minimum;
	
	@Column(name = "Max")
	private  Float maximum;
	
	@Column(name = "Error")
	private  Float error;
	
	@Column(name = "date_excuted")
	private Date dateExecuted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getSamples() {
		return samples;
	}

	public void setSamples(Integer samples) {
		this.samples = samples;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public Float getNintyPercent() {
		return NintyPercent;
	}

	public void setNintyPercent(Float nintyPercent) {
		NintyPercent = nintyPercent;
	}

	public Float getMinimum() {
		return minimum;
	}

	public void setMinimum(Float minimum) {
		this.minimum = minimum;
	}

	public Float getMaximum() {
		return maximum;
	}

	public void setMaximum(Float maximum) {
		this.maximum = maximum;
	}

	public Float getError() {
		return error;
	}

	public void setError(Float error) {
		this.error = error;
	}

	public String getDateExecuted() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
		String strDate = sdf.format(dateExecuted);
		return strDate;
	}

	public void setDateExecuted(Date dateExecuted) {
		this.dateExecuted = dateExecuted;
	}

	public JmeterResults(Integer id, String label, Integer samples, Float average, Float nintyPercent, Float minimum,
			Float maximum, Float error, Date dateExecuted) {
		super();
		this.id = id;
		this.label = label;
		this.samples = samples;
		this.average = average;
		NintyPercent = nintyPercent;
		this.minimum = minimum;
		this.maximum = maximum;
		this.error = error;
		this.dateExecuted = dateExecuted;
	}

	public JmeterResults() {
		super();
		
	}

	@Override
	public String toString() {
		return "JmeterResults [id=" + id + ", label=" + label + ", samples=" + samples + ", average=" + average
				+ ", NintyPercent=" + NintyPercent + ", minimum=" + minimum + ", maximum=" + maximum + ", error="
				+ error + ", dateExecuted=" + dateExecuted + "]";
	}

	

}
