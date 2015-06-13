/*
*Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*WSO2 Inc. licenses this file to you under the Apache License,
*Version 2.0 (the "License"); you may not use this file except
*in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing,
*software distributed under the License is distributed on an
*"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*KIND, either express or implied.  See the License for the
*specific language governing permissions and limitations
*under the License.
*/
package org.wso2.carbon.identity.oauth2.token.handlers.grant.iwa.ntlm.util;

import org.apache.catalina.AccessLog;
import org.apache.catalina.Authenticator;
import org.apache.catalina.Cluster;
import org.apache.catalina.Container;
import org.apache.catalina.ContainerListener;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.Loader;
import org.apache.catalina.Manager;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Realm;
import org.apache.catalina.ThreadBindingListener;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.deploy.NamingResourcesImpl;
import org.apache.juli.logging.Log;
import org.apache.tomcat.InstanceManager;
import org.apache.tomcat.JarScanner;
import org.apache.tomcat.util.descriptor.web.ApplicationParameter;
import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.apache.tomcat.util.http.CookieProcessor;

import javax.management.ObjectName;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletSecurityElement;
import javax.servlet.descriptor.JspConfigDescriptor;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class SimpleContext implements Context {

	private Realm _realm = null;
	private ServletContext _servletContext = new SimpleServletContext();

	@Override
	public boolean getAllowCasualMultipartParsing() {
		return false;
	}

	@Override
	public void setAllowCasualMultipartParsing(boolean b) {

	}

	@Override
	public Object[] getApplicationEventListeners() {
		return new Object[0];
	}

	@Override
	public void setApplicationEventListeners(Object[] objects) {

	}

	@Override
	public Object[] getApplicationLifecycleListeners() {
		return new Object[0];
	}

	@Override
	public void setApplicationLifecycleListeners(Object[] objects) {

	}

	@Override
	public String getCharset(Locale locale) {
		return null;
	}

	@Override
	public URL getConfigFile() {
		return null;
	}

	@Override
	public void setConfigFile(URL url) {

	}

	@Override
	public boolean getConfigured() {
		return false;
	}

	@Override
	public void setConfigured(boolean b) {

	}

	@Override
	public boolean getCookies() {
		return false;
	}

	@Override
	public void setCookies(boolean b) {

	}

	@Override
	public String getSessionCookieName() {
		return null;
	}

	@Override
	public void setSessionCookieName(String s) {

	}

	@Override
	public boolean getUseHttpOnly() {
		return false;
	}

	@Override
	public void setUseHttpOnly(boolean b) {

	}

	@Override
	public String getSessionCookieDomain() {
		return null;
	}

	@Override
	public void setSessionCookieDomain(String s) {

	}

	@Override
	public String getSessionCookiePath() {
		return null;
	}

	@Override
	public void setSessionCookiePath(String s) {

	}

	@Override
	public boolean getSessionCookiePathUsesTrailingSlash() {
		return false;
	}

	@Override
	public void setSessionCookiePathUsesTrailingSlash(boolean b) {

	}

	@Override
	public boolean getCrossContext() {
		return false;
	}

	@Override
	public String getAltDDName() {
		return null;
	}

	@Override
	public void setAltDDName(String s) {

	}

	@Override
	public void setCrossContext(boolean b) {

	}

	@Override
	public boolean getDenyUncoveredHttpMethods() {
		return false;
	}

	@Override
	public void setDenyUncoveredHttpMethods(boolean b) {

	}

	@Override
	public String getDisplayName() {
		return null;
	}

	@Override
	public void setDisplayName(String s) {

	}

	@Override
	public boolean getDistributable() {
		return false;
	}

	@Override
	public void setDistributable(boolean b) {

	}

	@Override
	public String getDocBase() {
		return null;
	}

	@Override
	public void setDocBase(String s) {

	}

	@Override
	public String getEncodedPath() {
		return null;
	}

	@Override
	public boolean getIgnoreAnnotations() {
		return false;
	}

	@Override
	public void setIgnoreAnnotations(boolean b) {

	}

	@Override
	public LoginConfig getLoginConfig() {
		return null;
	}

	@Override
	public void setLoginConfig(LoginConfig loginConfig) {

	}

	@Override
	public NamingResourcesImpl getNamingResources() {
		return null;
	}

	@Override
	public void setNamingResources(NamingResourcesImpl namingResources) {

	}

	@Override
	public String getPath() {
		return null;
	}

	@Override
	public void setPath(String s) {

	}

	@Override
	public String getPublicId() {
		return null;
	}

	@Override
	public void setPublicId(String s) {

	}

	@Override
	public boolean getReloadable() {
		return false;
	}

	@Override
	public void setReloadable(boolean b) {

	}

	@Override
	public boolean getOverride() {
		return false;
	}

	@Override
	public void setOverride(boolean b) {

	}

	@Override
	public boolean getPrivileged() {
		return false;
	}

	@Override
	public void setPrivileged(boolean b) {

	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Override
	public int getSessionTimeout() {
		return 0;
	}

	@Override
	public void setSessionTimeout(int i) {

	}

	@Override
	public boolean getSwallowAbortedUploads() {
		return false;
	}

	@Override
	public void setSwallowAbortedUploads(boolean b) {

	}

	@Override
	public boolean getSwallowOutput() {
		return false;
	}

	@Override
	public void setSwallowOutput(boolean b) {

	}

	@Override
	public String getWrapperClass() {
		return null;
	}

	@Override
	public void setWrapperClass(String s) {

	}

	@Override
	public boolean getXmlNamespaceAware() {
		return false;
	}

	@Override
	public void setXmlNamespaceAware(boolean b) {

	}

	@Override
	public boolean getXmlValidation() {
		return false;
	}

	@Override
	public void setXmlValidation(boolean b) {

	}

	@Override
	public boolean getXmlBlockExternal() {
		return false;
	}

	@Override
	public void setXmlBlockExternal(boolean b) {

	}

	@Override
	public boolean getTldValidation() {
		return false;
	}

	@Override
	public void setTldValidation(boolean b) {

	}

	@Override
	public JarScanner getJarScanner() {
		return null;
	}

	@Override
	public void setJarScanner(JarScanner jarScanner) {

	}

	@Override
	public Authenticator getAuthenticator() {
		return null;
	}

	@Override
	public void setLogEffectiveWebXml(boolean b) {

	}

	@Override
	public boolean getLogEffectiveWebXml() {
		return false;
	}

	@Override
	public InstanceManager getInstanceManager() {
		return null;
	}

	@Override
	public void setInstanceManager(InstanceManager instanceManager) {

	}

	@Override
	public void setContainerSciFilter(String s) {

	}

	@Override
	public String getContainerSciFilter() {
		return null;
	}

	@Override
	public void addApplicationListener(String s) {

	}

	@Override
	public void addApplicationParameter(ApplicationParameter applicationParameter) {

	}

	@Override
	public void addConstraint(SecurityConstraint securityConstraint) {

	}

	@Override
	public void addErrorPage(ErrorPage errorPage) {

	}

	@Override
	public void addFilterDef(FilterDef filterDef) {

	}

	@Override
	public void addFilterMap(FilterMap filterMap) {

	}

	@Override
	public void addFilterMapBefore(FilterMap filterMap) {

	}

	@Override
	public void addInstanceListener(String s) {

	}

	@Override
	public void addLocaleEncodingMappingParameter(String s, String s1) {

	}

	@Override
	public void addMimeMapping(String s, String s1) {

	}

	@Override
	public void addParameter(String s, String s1) {

	}

	@Override
	public void addRoleMapping(String s, String s1) {

	}

	@Override
	public void addSecurityRole(String s) {

	}

	@Override
	public void addServletMapping(String s, String s1) {

	}

	@Override
	public void addServletMapping(String s, String s1, boolean b) {

	}

	@Override
	public void addWatchedResource(String s) {

	}

	@Override
	public void addWelcomeFile(String s) {

	}

	@Override
	public void addWrapperLifecycle(String s) {

	}

	@Override
	public void addWrapperListener(String s) {

	}

	@Override
	public Wrapper createWrapper() {
		return null;
	}

	@Override
	public String[] findApplicationListeners() {
		return new String[0];
	}

	@Override
	public ApplicationParameter[] findApplicationParameters() {
		return new ApplicationParameter[0];
	}

	@Override
	public SecurityConstraint[] findConstraints() {
		return new SecurityConstraint[0];
	}

	@Override
	public ErrorPage findErrorPage(int i) {
		return null;
	}

	@Override
	public ErrorPage findErrorPage(String s) {
		return null;
	}

	@Override
	public ErrorPage[] findErrorPages() {
		return new ErrorPage[0];
	}

	@Override
	public FilterDef findFilterDef(String s) {
		return null;
	}

	@Override
	public FilterDef[] findFilterDefs() {
		return new FilterDef[0];
	}

	@Override
	public FilterMap[] findFilterMaps() {
		return new FilterMap[0];
	}

	@Override
	public String[] findInstanceListeners() {
		return new String[0];
	}

	@Override
	public String findMimeMapping(String s) {
		return null;
	}

	@Override
	public String[] findMimeMappings() {
		return new String[0];
	}

	@Override
	public String findParameter(String s) {
		return null;
	}

	@Override
	public String[] findParameters() {
		return new String[0];
	}

	@Override
	public String findRoleMapping(String s) {
		return null;
	}

	@Override
	public boolean findSecurityRole(String s) {
		return false;
	}

	@Override
	public String[] findSecurityRoles() {
		return new String[0];
	}

	@Override
	public String findServletMapping(String s) {
		return null;
	}

	@Override
	public String[] findServletMappings() {
		return new String[0];
	}

	@Override
	public String findStatusPage(int i) {
		return null;
	}

	@Override
	public int[] findStatusPages() {
		return new int[0];
	}

	@Override
	public ThreadBindingListener getThreadBindingListener() {
		return null;
	}

	@Override
	public void setThreadBindingListener(ThreadBindingListener threadBindingListener) {

	}

	@Override
	public String[] findWatchedResources() {
		return new String[0];
	}

	@Override
	public boolean findWelcomeFile(String s) {
		return false;
	}

	@Override
	public String[] findWelcomeFiles() {
		return new String[0];
	}

	@Override
	public String[] findWrapperLifecycles() {
		return new String[0];
	}

	@Override
	public String[] findWrapperListeners() {
		return new String[0];
	}

	@Override
	public boolean fireRequestInitEvent(ServletRequest servletRequest) {
		return false;
	}

	@Override
	public boolean fireRequestDestroyEvent(ServletRequest servletRequest) {
		return false;
	}

	@Override
	public void reload() {

	}

	@Override
	public void removeApplicationListener(String s) {

	}

	@Override
	public void removeApplicationParameter(String s) {

	}

	@Override
	public void removeConstraint(SecurityConstraint securityConstraint) {

	}

	@Override
	public void removeErrorPage(ErrorPage errorPage) {

	}

	@Override
	public void removeFilterDef(FilterDef filterDef) {

	}

	@Override
	public void removeFilterMap(FilterMap filterMap) {

	}

	@Override
	public void removeInstanceListener(String s) {

	}

	@Override
	public void removeMimeMapping(String s) {

	}

	@Override
	public void removeParameter(String s) {

	}

	@Override
	public void removeRoleMapping(String s) {

	}

	@Override
	public void removeSecurityRole(String s) {

	}

	@Override
	public void removeServletMapping(String s) {

	}

	@Override
	public void removeWatchedResource(String s) {

	}

	@Override
	public void removeWelcomeFile(String s) {

	}

	@Override
	public void removeWrapperLifecycle(String s) {

	}

	@Override
	public void removeWrapperListener(String s) {

	}

	@Override
	public String getRealPath(String s) {
		return null;
	}

	@Override
	public int getEffectiveMajorVersion() {
		return 0;
	}

	@Override
	public void setEffectiveMajorVersion(int i) {

	}

	@Override
	public int getEffectiveMinorVersion() {
		return 0;
	}

	@Override
	public void setEffectiveMinorVersion(int i) {

	}

	@Override
	public JspConfigDescriptor getJspConfigDescriptor() {
		return null;
	}

	@Override
	public void setJspConfigDescriptor(JspConfigDescriptor jspConfigDescriptor) {

	}

	@Override
	public void addServletContainerInitializer(ServletContainerInitializer servletContainerInitializer,
	                                           Set<Class<?>> set) {

	}

	@Override
	public boolean getPaused() {
		return false;
	}

	@Override
	public boolean isServlet22() {
		return false;
	}

	@Override
	public Set<String> addServletSecurity(ServletRegistration.Dynamic dynamic,
	                                      ServletSecurityElement servletSecurityElement) {
		return null;
	}

	@Override
	public void setResourceOnlyServlets(String s) {

	}

	@Override
	public String getResourceOnlyServlets() {
		return null;
	}

	@Override
	public boolean isResourceOnlyServlet(String s) {
		return false;
	}

	@Override
	public String getBaseName() {
		return null;
	}

	@Override
	public void setWebappVersion(String s) {

	}

	@Override
	public String getWebappVersion() {
		return null;
	}

	@Override
	public void setFireRequestListenersOnForwards(boolean b) {

	}

	@Override
	public boolean getFireRequestListenersOnForwards() {
		return false;
	}

	@Override
	public void setPreemptiveAuthentication(boolean b) {

	}

	@Override
	public boolean getPreemptiveAuthentication() {
		return false;
	}

	@Override
	public void setSendRedirectBody(boolean b) {

	}

	@Override
	public boolean getSendRedirectBody() {
		return false;
	}

	@Override
	public Loader getLoader() {
		return null;
	}

	@Override
	public void setLoader(Loader loader) {

	}

	@Override
	public WebResourceRoot getResources() {
		return null;
	}

	@Override
	public void setResources(WebResourceRoot webResourceRoot) {

	}

	@Override
	public Manager getManager() {
		return null;
	}

	@Override
	public void setManager(Manager manager) {

	}

	@Override
	public void setAddWebinfClassesResources(boolean b) {

	}

	@Override
	public boolean getAddWebinfClassesResources() {
		return false;
	}

	@Override
	public void addPostConstructMethod(String s, String s1) {

	}

	@Override
	public void addPreDestroyMethod(String s, String s1) {

	}

	@Override
	public void removePostConstructMethod(String s) {

	}

	@Override
	public void removePreDestroyMethod(String s) {

	}

	@Override
	public String findPostConstructMethod(String s) {
		return null;
	}

	@Override
	public String findPreDestroyMethod(String s) {
		return null;
	}

	@Override
	public Map<String, String> findPostConstructMethods() {
		return null;
	}

	@Override
	public Map<String, String> findPreDestroyMethods() {
		return null;
	}

	@Override
	public ClassLoader bind(boolean b, ClassLoader classLoader) {
		return null;
	}

	@Override
	public void unbind(boolean b, ClassLoader classLoader) {

	}

	@Override
	public Object getNamingToken() {
		return null;
	}

	@Override
	public void setCookieProcessor(CookieProcessor cookieProcessor) {

	}

	@Override
	public CookieProcessor getCookieProcessor() {
		return null;
	}

	@Override
	public Log getLogger() {
		return null;
	}

	@Override
	public ObjectName getObjectName() {
		return null;
	}

	@Override
	public String getDomain() {
		return null;
	}

	@Override
	public String getMBeanKeyProperties() {
		return null;
	}

	@Override
	public Pipeline getPipeline() {
		return null;
	}

	@Override
	public Cluster getCluster() {
		return null;
	}

	@Override
	public void setCluster(Cluster cluster) {

	}

	@Override
	public int getBackgroundProcessorDelay() {
		return 0;
	}

	@Override
	public void setBackgroundProcessorDelay(int i) {

	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void setName(String s) {

	}

	@Override
	public Container getParent() {
		return null;
	}

	@Override
	public void setParent(Container container) {

	}

	@Override
	public ClassLoader getParentClassLoader() {
		return null;
	}

	@Override
	public void setParentClassLoader(ClassLoader classLoader) {

	}

	@Override
	public Realm getRealm() {
		return _realm;
	}

	@Override
	public void setRealm(Realm realm) {
		_realm = realm;
	}

	@Override
	public void backgroundProcess() {

	}

	@Override
	public void addChild(Container container) {

	}

	@Override
	public void addContainerListener(ContainerListener containerListener) {

	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {

	}

	@Override
	public Container findChild(String s) {
		return null;
	}

	@Override
	public Container[] findChildren() {
		return new Container[0];
	}

	@Override
	public ContainerListener[] findContainerListeners() {
		return new ContainerListener[0];
	}

	@Override
	public void removeChild(Container container) {

	}

	@Override
	public void removeContainerListener(ContainerListener containerListener) {

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {

	}

	@Override
	public void fireContainerEvent(String s, Object o) {

	}

	@Override
	public void logAccess(Request request, Response response, long l, boolean b) {

	}

	@Override
	public AccessLog getAccessLog() {
		return null;
	}

	@Override
	public int getStartStopThreads() {
		return 0;
	}

	@Override
	public void setStartStopThreads(int i) {

	}

	@Override
	public File getCatalinaBase() {
		return null;
	}

	@Override
	public File getCatalinaHome() {
		return null;
	}

	@Override
	public void addLifecycleListener(LifecycleListener lifecycleListener) {

	}

	@Override
	public LifecycleListener[] findLifecycleListeners() {
		return new LifecycleListener[0];
	}

	@Override
	public void removeLifecycleListener(LifecycleListener lifecycleListener) {

	}

	@Override
	public void init() throws LifecycleException {

	}

	@Override
	public void start() throws LifecycleException {

	}

	@Override
	public void stop() throws LifecycleException {

	}

	@Override
	public void destroy() throws LifecycleException {

	}

	@Override
	public LifecycleState getState() {
		return null;
	}

	@Override
	public String getStateName() {
		return null;
	}
}