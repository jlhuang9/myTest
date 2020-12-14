package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * @author huangchengqian
 * @date 2020-12-13 14:59
 **/
public class TestConfig extends JobProperty<Job<?, ?>> {

    @DataBoundConstructor
    public TestConfig() {
    }

    @Extension
    @Symbol("testProperties")
    public static final class TestProperties extends JobPropertyDescriptor {


        public TestProperties() {
            super(TestConfig.class);
            load();
        }

        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            return true;
        }

//        @Override
//        public boolean configure(StaplerRequest req, JSONObject formData)
//                throws FormException {
//            req.bindParameters(this);
//            this.disable = formData.getBoolean("disable");
//            save();
//            return super.configure(req, formData);
//        }
//
//        public boolean isDisable() {
//            return disable;
//        }
    }
}
