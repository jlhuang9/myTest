package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

/**
 * @author huangchengqian
 * @date 2020-12-10 12:45
 **/
@Extension(ordinal = 101)
public final class DescriptorImpl extends
        GlobalConfiguration {

    private String domain;

    public DescriptorImpl() {
        this.load();
    }

    @DataBoundConstructor
    public DescriptorImpl(String domain) {
        this.domain = domain;
    }

    @DataBoundSetter
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject formData)
            throws FormException {
        req.bindParameters(this);
        this.domain = formData.getString("domain");
        save();
        return super.configure(req, formData);
    }

    @Override
    public String getDisplayName() {
        return "企业微信通知1";
    }

    public String getDomain() {
        return domain;
    }

    public static DescriptorImpl get() {
        return GlobalConfiguration.all().get(DescriptorImpl.class);
    }
}
